package br.objective.model;

public class Prato implements Comparable<Prato>{

	private String nome;
	private String caracteristica;

	public Prato(String nome, String caracteristica) {
		this.nome = nome;
		this.caracteristica = caracteristica;
	}

	public String getNome() {
		return nome;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	@Override
	public String toString() {
		return "Prato [nome=" + nome + ", caracteristica=" + caracteristica + "]";
	}

	@Override
	public int compareTo(Prato o) {
		return this.nome.compareTo(o.getNome());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
