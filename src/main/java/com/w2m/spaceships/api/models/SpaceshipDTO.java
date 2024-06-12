package com.w2m.spaceships.api.models;

public class SpaceshipDTO {

    private Long id;
    private String name;
    private String movie;
    private String series;

    public SpaceshipDTO() {
    }

    public SpaceshipDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "SpaceshipDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getSeries() {
		return series;
	}

	public void setSerie(String series) {
		this.series = series;
	}
}
