import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Aluno;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud");
		EntityManager em = emf.createEntityManager();
		
		
		
		Aluno a = new Aluno("1234", "MARIA", "maria@ccc.ufcg.edu.br");
		Aluno b = new Aluno("1543", "JULIA", "julia@ccc.ufcg.edu.br");
		Aluno c = new Aluno("1111", "ARTHUR", "arthur@ccc.ufcg.edu.br");
		
//Persiste os alunos no banco de dados		
//		em.getTransaction().begin();
//		em.persist(a);
//		em.persist(b);
//		em.persist(c);
//		em.getTransaction().commit();
	
//Recupera aluno por matricula		
//		Aluno aluno = em.find(Aluno.class, "1234");
//		
//		System.out.println(aluno);
	
//Altera email de um aluno		
//		a.setNome("Maria Joaquina");
//		em.getTransaction().begin();
//		em.merge(a);
//		em.getTransaction().commit();
	
//Remove do banco de dados um aluno existente - precisa primeiro rastrear(recuperar) pra depois remover
//		Aluno aluno = em.find(Aluno.class, "1111");
//		
//		em.getTransaction().begin();
//		em.remove(aluno);
//		em.getTransaction().commit();
		
		Query query = em.createQuery("FROM Aluno WHERE nome LIKE :nome");
		query.setParameter("nome", "%"+"JULIA"+"%");
		query.setMaxResults(1);
		
		List<Aluno> listAluno = query.getResultList();
		if(listAluno.isEmpty()) {
			System.out.println("Aluno não encontrado");
		}
		System.out.println(listAluno.get(0));
		
		
		System.out.println("fim");
	}
	
	

}
