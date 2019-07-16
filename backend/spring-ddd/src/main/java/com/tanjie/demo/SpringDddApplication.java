package com.tanjie.demo;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tanjie.demo.domain.ExeciseEntry;
import com.tanjie.demo.domain.ExeciseEntryGroup;
import com.tanjie.demo.domain.ExecisePlan;
import com.tanjie.demo.domain.ExeciseProject;
import com.tanjie.demo.domain.example1.Category;
import com.tanjie.demo.repository.ExeciseEntryRepository;
import com.tanjie.demo.repository.ExecisePlanRepository;
import com.tanjie.demo.repository.ExeciseProjectRepository;
import com.tanjie.demo.service.example0.OrderService;
import com.tanjie.demo.service.example1.CategoryService;

@SpringBootApplication
public class SpringDddApplication implements CommandLineRunner {

    @Autowired
    private ExecisePlanRepository execisePlanRepository;
    @Autowired
    private ExeciseEntryRepository execiseEntryRepository;
    @Autowired
    private ExeciseProjectRepository execiseProjectRepository;
    @Autowired
    private OrderService orderService;

    @Autowired
    private CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDddApplication.class, args);
        System.out.println("Application was startted.");

    }

    @Override
    public void run(String... args) throws Exception {
        // 创建一个锻炼计划实例
        ExecisePlan execisePlan = new ExecisePlan();
        execisePlan.setGroup(3);
        execisePlan.setStartTime(Instant.now());

        // 向锻炼计划实例中添加锻炼项
        ExeciseEntryGroup entryGroup = new ExeciseEntryGroup();
        entryGroup.setName("first group");
        entryGroup.setNumber(0);

        ExeciseEntryGroup entryGroup1 = new ExeciseEntryGroup();
        entryGroup1.setName("second group");
        entryGroup1.setNumber(0);

        // 创建锻炼项目
        ExeciseProject execiseProject = new ExeciseProject();
        execiseProject.setName("project01");

        ExeciseProject execiseProject1 = new ExeciseProject();
        execiseProject.setName("project02");

        // 保存锻炼项目
        execiseProjectRepository.save(execiseProject);
        execiseProjectRepository.save(execiseProject1);

        ExeciseEntry execiseEntry = new ExeciseEntry();
        execiseEntry.setTarget(30);
        execiseEntry.setIsFinished(false);
        execiseEntry.addExeciseEntryGroup(entryGroup);
        execiseEntry.addExeciseEntryGroup(entryGroup1);
        execiseEntry.setExeciseProject(execiseProject);

        ExeciseEntry execiseEntry1 = new ExeciseEntry();
        execiseEntry1.setTarget(30);
        execiseEntry1.setIsFinished(false);
        execiseEntry1.addExeciseEntryGroup(entryGroup);
        execiseEntry1.addExeciseEntryGroup(entryGroup1);
        execiseEntry1.setExeciseProject(execiseProject1);

        // 添加锻炼项
        execisePlan.addExeciseEntry(execiseEntry);
        execisePlan.addExeciseEntry(execiseEntry1);

        // 写入数据库
      //  ExecisePlan save = execisePlanRepository.save(execisePlan);
       // System.out.println(save.toString());

        // 删除锻炼项
//        ExecisePlan deletedExecisePlan = save.deleteExeciseEntry(execiseEntry);
//        Set<ExeciseEntry> execiseEntries = deletedExecisePlan.getExeciseEntries();
//        execiseEntries.forEach(entry -> {
//            System.out.println(entry.toString());
//        });
//
//        execisePlanRepository.save(deletedExecisePlan);
//        System.out.println(save.toString());

        //categoryService.initial();

        //Category category = categoryService.findById(2L);
        //categoryService.traverseCategory(category);
        //categoryService.delteAll(category);
        
        //orderService.payOrder1();
        orderService.payOrder();

    }

}
