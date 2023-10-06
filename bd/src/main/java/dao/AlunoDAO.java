package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Aluno;

public class AlunoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoDAO(){
		
		this.emf = Persistence.createEntityManagerFactory("crud");	
		this.em =  emf.createEntityManager();
		
	}
	
	public Aluno findByMatricula(String matricula) {
		return em.find(Aluno.class, matricula);
		
	}
	
	public void persist(Aluno aluno) {
		em.getTransaction().begin();
        em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public void updateNome(Aluno aluno, String nome ) {
		aluno.setNome(nome);
		em.getTransaction().begin();
		em.merge(aluno);
        em.getTransaction().commit();
		
	}
	
	public void updateEmail(Aluno aluno, String email ) {
		aluno.setNome(email);
		em.getTransaction().begin();
		em.merge(aluno);
        em.getTransaction().commit();
		
	}
	
	public void removeByMatricula(String matricula) {
		
		Aluno aluno = this.findByMatricula(matricula);
		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
		
	}
	
	//retorna a lista com todos os alunos que tem esse nome
	public List<Aluno> createQuery(String nome) {
		Query query = em.createQuery("FROM Aluno WHERE nome LIKE :nome");
		query.setParameter("nome", "%"+nome+"%");
//		query.setMaxResults(1);
		
		List<Aluno> listAluno = query.getResultList();	
		return listAluno;
		
	}

}
