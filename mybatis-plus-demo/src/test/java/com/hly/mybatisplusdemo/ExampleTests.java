package com.hly.mybatisplusdemo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hly.mybatisplusdemo.entity.Example;
import com.hly.mybatisplusdemo.mapper.ExampleMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleTests {

    @Autowired
    private ExampleMapper exampleMapper;

    @Test
    public void test(){
        /*Example example = new Example(1, "huliangyan");
        exampleMapper.insert(example);*/
//        exampleMapper.deleteById(1);

        /*Example example = new Example(2, "ccc");
        EntityWrapper<Example> wrapper = new EntityWrapper<Example>();
        wrapper.setEntity(example);
        exampleMapper.delete(wrapper);*/
        List<Example> list = exampleMapper.selectList(null);
        Assert.assertEquals(3, list.size());


        /*Example e = exampleMapper.selectById(1);*/
        /*Map<String, Object> map = new HashMap<>();
        map.put("id", 5);
        List<Example> e = exampleMapper.selectByMap(map);*/

    }
}
