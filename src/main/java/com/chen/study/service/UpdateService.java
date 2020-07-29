package com.chen.study.service;

import com.chen.study.mapper.UpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
    @Autowired
    private UpdateMapper updateMapper;

    public int updateName(String name){
        return updateMapper.updateName(name);
    }
}
