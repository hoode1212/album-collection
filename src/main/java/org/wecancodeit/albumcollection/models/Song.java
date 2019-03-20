package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	private String songTitle;
	private String duration;
	private String link;
	@ManyToOne
	@JsonIgnore
	private Album album;
	@OneToMany(mappedBy="song")
	private Collection<Rating> ratings;
	@ElementCollection
	@CollectionTable
	private Collection<Comment> comments;
	@ManyToMany
	private Collection<Tag> tags;
	
	public Song() {}
	
	public Song(String songTitle, String duration, String link, Album album) {
		this.songTitle = songTitle;
		this.duration = duration;
		this.link = link;
		this.album = album;
		this.tags = new ArrayList<Tag>();
		this.comments = new ArrayList<Comment>();
	}

	public Long getId() {
		return id;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public String getDuration() {
		return duration;
	}

	public String getLink() {
		return link;
	}
	
	public Album getAlbum() {
		return album;
	}
	
	public Collection<Rating> getRatings() {
		return ratings;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTags() {
		return tags;
	}
	
	public void addTagtoTags(Tag tagToAdd) {
		tags.add(tagToAdd);
	}

	public void addComment(Comment commentToAdd) {
		comments.add(commentToAdd);
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songTitle=" + songTitle + ", duration=" + duration + ", link=" + link + ", album="
				+ album + ", ratings=" + ratings + ", comments=" + comments + ", tags=" + tags + "]";
	}

	
}
