package com.example.g5project.repository.repo;

import com.example.g5project.exception.EntityNotExistException;
import com.example.g5project.tools.EntityUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName Repo.java
 * @Description TODO
 * @createTime 2022年03月25日 14:55:00
 */
public abstract class Repo<Type, ID> {
    protected final JpaRepository<Type, ID> dao;

    protected Repo(JpaRepository<Type, ID> dao) {
        this.dao = dao;
    }

    public Optional<Type> findById(ID id) {
        Preconditions.checkNotNull(id, "未输入ID");
        return dao.findById(id);
    }

    public void save(Type type) {
        Preconditions.checkNotNull(type, "未输入内容");
        dao.save(type);
    }

    public void deleteById(ID id) {
        Preconditions.checkNotNull(id, "未输入ID");
        dao.deleteById(id);
    }

    public void updateById(ID id, Type type) throws EntityNotExistException {
        Preconditions.checkNotNull(id, "未输入id");
        Preconditions.checkNotNull(type, "未输入信息");
        Optional<Type> opt = findById(id);
        if (!opt.isPresent()) {
            throw new EntityNotExistException();
        }
        Type after = EntityUtils.copyProperties(type, opt.get(), true);
        save(after);
    }


}
