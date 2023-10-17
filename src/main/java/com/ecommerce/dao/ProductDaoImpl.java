package com.ecommerce.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sf;

	@Override
	public List<Product> getAllProducts() {

		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria cr = session.createCriteria(Product.class);
			list = cr.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProductById(int id) {
		Session session = sf.openSession();
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	public boolean saveproduct(Product product) {
		Session session = sf.openSession();
		 boolean isAdded =false;
		
		try {
			Transaction tr = session.beginTransaction();
			Product product2 = session.get(Product.class, product.getId());
			session.evict(product2);
			if(product2==null) {
				session.save(product);
				isAdded=true;
				tr.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteProductById(int id) {
		boolean isDeleted = false;
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Product product = session.get(Product.class, id);
			if (product != null) {
				session.delete(product);
				isDeleted = true;
				tr.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updateProductById(Product product) {
		boolean isUpdated = false;
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Product product2 = session.get(Product.class, product.getId());
			session.evict(product2);
			if (product2 != null) {
				session.update(product);
				tr.commit();
				isUpdated = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public List<Product> getAllProductByAscendingOrde() {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.addOrder(Order.asc("prize"));
			list = ctr.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Product getProductByName(String name) {
		Session session = sf.openSession();
		Product product = null;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.add(Restrictions.eq("name", name));
			List<Product> list = ctr.list();
			if (!list.isEmpty()) {
				product = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return product;
	}

	@Override
	public List<Product> getAllProductGreterthen(double prize) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.add(Restrictions.gt("prize", prize));
			list = ctr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Product> getProductBetween(double minPrize, double maxPrize) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.add(Restrictions.between("prize", minPrize, maxPrize));
			list = ctr.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public double sumOfProductPrize() {
		Session session = sf.openSession();
		Double sum = 0.0;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.setProjection(Projections.sum("prize"));
			List<Double> list = ctr.list();
			if (!list.isEmpty()) {
				sum = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return sum;
	}

	@Override
	public long getRowCount() {
		Session session = sf.openSession();
		long count=0;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.setProjection(Projections.rowCount());
			List<Long> list = ctr.list();
			if(!list.isEmpty()) {
				count=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public double getMaxPrize() {
		Session session = sf.openSession();
		double maxPrize=0;
		try {
			Criteria ctr = session.createCriteria(Product.class);
			ctr.setProjection(Projections.max("prize"));
			List<Double>list = ctr.list();
			if(!list.isEmpty()){
				maxPrize=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return maxPrize;
	}
	
	@Override
	public int deleteProductUsingHql(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		int row =0;
		try {
			
			Query query = session.createQuery("DELETE FROM PRODUCT WHERE ID = :ID");
			query.setParameter("id", id);
			row = query.executeUpdate();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return row;
	}

}
















