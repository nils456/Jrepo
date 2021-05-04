package com.in28minutes.rest.webservices.restfulwebservices.post;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;

@Component
public class PostDaoService {
	private static List<Post> posts = new ArrayList<>();

	private static int postsCount = 7;

	static {
		posts.add(new Post(1, "Precautions During Winter", new Date(), "Wear warm clothes. Drink hot water. Do yoga.", 1 ));
		posts.add(new Post(2, "Work From Home Tips", new Date(), "Have a quiet workplace without interruptions. Keep distractions away.", 3));
		posts.add(new Post(3, "Trekking Tips", new Date(), "Carry sufficient water and food. Take frequent breaks. Go by known route", 2));
		posts.add(new Post(4, "Style Tips", new Date(), "Dress comfortably. Wear light makeup. Dress to suit your figure.", 2));
		posts.add(new Post(5, "Mzzz Tips", new Date(), "ppppppsdsdsdsds. mmmmmmmmeeeeessxss", 2));
	}

	public List<Post> findAll() {
		return posts;
	}
	public Post save(Post post) {
		if (post.getId() == null) {
			post.setId(++postsCount);
		}
		posts.add(post);
		return post;
	}

	public Post findByTitle(String title) {
		for (Post post : posts) {
			if (post.getTitle().equals(title)) {
				return post;
			}
		}
		return null;
	}
	public Post deleteByTitle(String title) {
		Iterator<Post> iterator = posts.iterator();
		while (iterator.hasNext()) {
			Post post = iterator.next();
			if (post.getTitle().equals(title)) {
				iterator.remove();
				return post;
			}
		}
		return null;
	}

	
}
