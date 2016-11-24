package br.com.psg.model;

public class TipoDocumento extends Colecao{
	
	private String descricaoTipoDocumento;

	public String getDescricao(int codTipo) {
		switch (codTipo) {
		case 1:
			this.setDescricao("NOTA FISCAL");
			break;
		case 2:
			this.setDescricao("DAEMS 27");
			break;
		case 3:
			this.setDescricao("AIDF");
			break;
		case 4:
			this.setDescricao("DAEMS 19");
			break;
		default:
			this.setDescricao("INDEFINIDO");
			break;
		}
		return descricaoTipoDocumento;
	}

	public void setDescricao(String descricao) {
		this.descricaoTipoDocumento = descricao;
	}

	public static void main(String[] args) {
		TipoDocumento t = new TipoDocumento();
		t.setTipoDocumento("1");
		String doc = t.getDescricao( Integer.parseInt(t.getTipo()));
		System.out.println("" + doc);
	}

}
