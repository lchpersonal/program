package com.chengli.nio.test.socket;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.channels.SelectionKey;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;

public class SelectSocketsThreadPool extends SelectSockets {
    private static final int MAX_THREADS = 5;
    private ThreadPool pool = new ThreadPool(MAX_THREADS);

    public static void main(String[] argv) throws Exception {
        new SelectSocketsThreadPool().go(argv);
    }

    protected void readDataFromSocket(SelectionKey key) throws Exception {
        WorkerThread worker = pool.getWorker();
        if (worker == null) {
            return;
        }
        worker.serviceChannel(key);
    }

    private class ThreadPool {
        List idle = new LinkedList();

        ThreadPool(int poolSize) {
            for (int i = 0; i < poolSize; i++) {
                WorkerThread thread = new WorkerThread(this);
                thread.setName("Worker" + (i + 1));
                thread.start();
                idle.add(thread);
            }
        }

        WorkerThread getWorker() {
            WorkerThread worker = null;
            synchronized (idle) {
                if (idle.size() > 0) {
                    worker = (WorkerThread) idle.remove(0);
                }
            }
            return (worker);
        }

        void returnWorker(WorkerThread worker) {
            synchronized (idle) {
                idle.add(worker);
            }
        }
    }

    private class WorkerThread extends Thread {
        private ByteBuffer buffer = ByteBuffer.allocate(1024);
        private ThreadPool pool;
        private SelectionKey key;

        WorkerThread(ThreadPool pool) {
            this.pool = pool;
        }

        public synchronized void run() {
            System.out.println(this.getName() + " is ready");
            while (true) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupted();
                }
                if (key == null) {
                    continue; // just in case
                }
                System.out.println(this.getName() + " has been awakened");
                try {
                    drainChannel(key);
                } catch (Exception e) {
                    System.out.println("Caught '" + e + "' closing channel");
                    try {
                        key.channel().close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    key.selector().wakeup();
                }
                key = null;
                this.pool.returnWorker(this);
            }
        }

        synchronized void serviceChannel(SelectionKey key) {
            this.key = key;
            key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
            this.notify(); // Awaken the thread
        }

        void drainChannel(SelectionKey key) throws Exception {
            SocketChannel channel = (SocketChannel) key.channel();
            int count;
            buffer.clear(); // Empty buffer
            while ((count = channel.read(buffer)) > 0) {
                buffer.flip(); // make buffer readable
                while (buffer.hasRemaining()) {
                    channel.write(buffer);
                }
                buffer.clear(); // Empty buffer
            }
            if (count < 0) {
                channel.close();
                return;
            }
            key.interestOps(key.interestOps() | SelectionKey.OP_READ);
            key.selector().wakeup();
        }
    }
}