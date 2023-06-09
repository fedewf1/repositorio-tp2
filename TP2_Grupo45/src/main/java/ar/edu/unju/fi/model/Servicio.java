package ar.edu.unju.fi.model;

public class Servicio {
		private String usuario;
		private String dia;
		private String hora;
		private String paseador;
		
		public Servicio(String usuario,String dia, String hora, String paseador) {
			this.usuario=usuario;
			this.dia=dia;
			this.hora=hora;
			this.paseador=paseador;
		}
		
		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getDia() {
			return dia;
		}

		public void setDia(String dia) {
			this.dia = dia;
		}

		public String getHora() {
			return hora;
		}

		public void setHora(String hora) {
			this.hora = hora;
		}

		public String getPaseador() {
			return paseador;
		}

		public void setPaseador(String paseador) {
			this.paseador = paseador;
		}

		
		
}
