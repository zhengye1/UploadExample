package com.uploadExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.uploadExample.model.AppUser;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public AppUser findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find( AppUser.class, id );
	}

	@Override
	public void save(AppUser user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AppUser> crit = cb.createQuery(AppUser.class);
		Root<AppUser> root = crit.from(AppUser.class);
		crit.select(root);
		return entityManager.createQuery(crit).getResultList();
	}

	@Override
	public void deleteByUsername(String username) {
		// TODO Auto-generated method stub
		AppUser user = findOneByField("username", username);
		entityManager.remove( user );
	}

	private AppUser findOneByField(String colName, String colValue) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AppUser> crit = cb.createQuery(AppUser.class);
		Root<AppUser> root = crit.from(AppUser.class);
		crit.where(cb.equal(root.get(colName), colValue));
		try{
			return entityManager.createQuery(crit).getSingleResult();
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public AppUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return findOneByField("username", username);
	}

}
