package clases;
/**
 * 
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class Usuario {
		/**
		 * nombre del usuario
		 */
		private String nombre;
		/**
		 * nombre de usuario del usuario
		 */
		private String nombreUsuario;
		/**
		 * contraseņa del usuario
		 */
		private String contrasenya;
		/**
		 * si el usuario es administrador o no
		 */
		private boolean admin;
		
		/**
		 * rellena los parametros con lo siguiente
		 * @param nombre con el nombre del usuario
		 * @param nombreUsuario con el nombre de usuario del usuario
		 * @param contrasenya con la contraseņa del usuario
		 * @param admin devuelve un true/false dependiendo de si es administrador o no
		 */
		public Usuario(String nombre, String nombreUsuario, String contrasenya, boolean admin) {
			super();
			this.nombre = nombre;
			this.nombreUsuario = nombreUsuario;
			this.contrasenya = contrasenya;
			this.admin = admin;
		}
		/**
		 * devuelve el nombre del usuario
		 * @return nombre del usuario
		 */
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
