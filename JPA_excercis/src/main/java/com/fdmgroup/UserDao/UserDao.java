package com.fdmgroup.UserDao;



import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class UserDao implements IUserDao{
	
	
	private EntityManagerFactory emf;
	
	
	

	public UserDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void persist(User user) {
		EntityManager em = null;
		
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
	
		
		em.getTransaction().commit();
		}finally {
			close(em);
		}
		
	}

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<User> findByUserName(String username) {

		EntityManager em = null;
		User findUser = null;
		TypedQuery<User>  query = null;
		
		try {
		
			em = emf.createEntityManager();
			query = em.createQuery("SELECT u FROM User u WHERE u.username = :Uname ",User.class);
			query.setParameter("Uname", username.toLowerCase());
		
			findUser =  query.getSingleResult();
		
		}finally {
			close(em);
			
		}
		return Optional.ofNullable(findUser);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		EntityManager em = null;
		
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		
		}finally {
			close(em);
		}
		
	}

	@Override
	public List<User> findAll() {
		EntityManager em = null;
		List<User> returnAllUser = null;
		
		try {
			em = emf.createEntityManager();
			TypedQuery<User> query = em.createNamedQuery("findAllUsers", User.class);
			returnAllUser = query.getResultList();
		}finally {
			
			close(em);
		}
		return returnAllUser;
	}
	
	
	static final void close(EntityManager em) {
		if(em != null && em.isOpen()) {
			em.close(); // Defensive coding
		}
	}

}
