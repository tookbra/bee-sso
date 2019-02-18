package com.tookbra.bee.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
public class CodeGenerator {

    public static void generator() {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/bee-sso-components/bee-generator/src/main/java");
        gc.setAuthor("tookbra");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setEnableCache(false);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/bee-king?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.tookbra.bee");
        pc.setModuleName("code");
        pc.setEntity("domain");
        pc.setMapper("dao");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);


        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(false);


        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude("JOB_ACTUATOR");

        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("CREATED_TIME", FieldFill.INSERT));
        tableFills.add(new TableFill("MODIFY_TIME", FieldFill.UPDATE));
        strategy.setTableFillList(tableFills);

        mpg.setStrategy(strategy);

        mpg.execute();
    }

    public static void main(String[] args) {
        generator();
    }
}
