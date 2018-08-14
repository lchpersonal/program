/**
 * @Author: chengli
 * @Date: 2018/8/14 14:59
 * <p>
 * 2018年系统性学习nio：
 *
 * <pre>
 * 一、nio和传统io的区别
 *      1.传统io面向流，而nio面向缓冲
 *      2.传统io是阻塞的，nio是非阻塞的
 *      3.nio有selector选择器
 *  传统io可以理解为一节水管，里面的水流就是数据，我们面向的就是水管中的水流；
 *  而nio可以理解为是火车轨道，轨道上跑的是火车(buffer)，火车中装的是数据。
 *  </pre>
 */
package com.chengli.nio.recent;