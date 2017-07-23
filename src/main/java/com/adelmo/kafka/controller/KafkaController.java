package com.adelmo.kafka.controller;

import com.adelmo.kafka.consumer.KafkaConsumerDemo;
import com.adelmo.kafka.producer.KafkaProducerDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by znb on 17-7-15.
 */
@Controller
public class KafkaController {

    @Resource(name = "kafkaProducerDemo")
    KafkaProducerDemo producer;

    @Resource(name = "kafkaConsumerDemo")
    KafkaConsumerDemo consumer;

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        System.out.println("--------welcome--------");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping(value = "/sendmessage", method = RequestMethod.GET)
    public ModelAndView sendMessage() {
        System.out.println("--------sendmessage--------");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(date);

        ModelAndView mv = new ModelAndView();
        mv.addObject("time", now);
        mv.setViewName("kafka_send");
        return mv;
    }

    @RequestMapping(value = "/onsend", method = RequestMethod.POST)
    public ModelAndView onsend(@RequestParam("message") String msg) {
        System.out.println("--------onsend--------");
        producer.sendMessage(msg);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping(value = "/receive")
    public ModelAndView receive() {
        System.out.println("--------receive--------");

        String msg = consumer.receive();

        System.out.println("---" + msg + "----");

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);
        mv.setViewName("kafka_receive");
        return mv;
    }

}