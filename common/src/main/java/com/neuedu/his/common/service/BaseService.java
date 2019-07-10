package com.neuedu.his.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.his.common.bean.BaseBean;
import com.neuedu.his.common.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends BaseBean,D extends BaseDao<T>> {
    @Autowired
    private D dao;

    public void insert(T t){
        t.preInsert();
        dao.insert(t);
    }

    public void insertBatch(List<T> list){
        dao.insertBatch(list);
    }

    public void update(T t){
        //更新updateTime的值
        t.preUpdate();
        dao.update(t);
    }

    public void delete(T condition){
        dao.delete(condition);
    }

    public void deleteById(String id){
        dao.findById(id);
    }

    public T findById(String id){
        return dao.findById(id);
    }

    public T find(T condition){
        return dao.find(condition);
    }

    public List<T> findList(T condition){
        return dao.findList(condition);
    }

    public List<T> findAll(){
        return dao.findAll();
    }

    /**
     * 根据Id是否存在判断是插入还是更新
     * @param t
     */
    public void save(T t){
        if(t.getId() != null && !t.getId().equals("")){
            update(t);
        }else {
            insert(t);
        }
    }
    /**
     * 根据条件查询分页数据
     * @Param pageNum 当前页码
     * @Param pageSize 每页多少条
     * @Param condition 条件
     * @return
     */
    public PageInfo<T> getPage(T condition,Integer pageNum,Integer pageSize){
       return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->dao.findList(condition));
    }
}
