package clases;

public class Usuario {
	
		private String nombre;
		private String nombreUsuario;
		private String contrasenya;
		private boolean admin;
		public Usuario(String nombre, String nombreUsuario, String contrasenya, boolean admin) {
			super();
			this.nombre = nombre;
			this.nombreUsuario = nombreUsuario;
			this.contrasenya = contrasenya;
			this.admin = admin;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getNombreUsuario() {
			return nombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		public String getContrasenya() {
			return contrasenya;
		}
		public void setContrasenya(String contrasenya) {
			this.contrasenya = contrasenya;
		}
		public boolean isAdmin() {
			return admin;
		}
		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

}
