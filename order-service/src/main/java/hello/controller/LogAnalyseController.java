package hello.controller;

import hello.log.LoggingTaskService;
import hello.order.OrderPurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogAnalyseController {

	@Autowired
	private OrderPurchaseService orderScheduler;

	@Autowired
	private LoggingTaskService loggingSchedulerService;


	@RequestMapping("/")
	public String home() {
		return "Elasticsearch - Simple Logging Application";
	}

	@RequestMapping("/log/start")
	public String log() {
		loggingSchedulerService.scheduleLogTasks();
		return "Log task running. See standard output";
	}

	@RequestMapping("/log/stop")
	public String cancelLog() {
		loggingSchedulerService.cancelLogTasks();
		return "Log task stopped.";
	}

	@RequestMapping("/order/start")
	public String order() {
		orderScheduler.scheduleOrderTasks();
		return "Order logs running. See standard output";
	}

	@RequestMapping("/order/stop")
	public String cancelOrder() {
		orderScheduler.cancelOrderTasks();
		return "Order logs stopped.";
	}
}
