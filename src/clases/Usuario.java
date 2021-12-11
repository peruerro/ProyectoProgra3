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
		 * contraseña del usuario
		 */
		private String contrasenya;
		/**
		 * si el usuario es administrador o no
		 */
		private int admin;
		
		/**
		 * rellena los parametros con lo siguiente
		 * @param nombre con el nombre del usuario
		 * @param nombreUsuario con el nombre de usuario del usuario
		 * @param contrasenya con la contraseña del usuario
		 * @param admin devuelve un true/false dependiendo de si es administrador o no
		 */
		public Usuario(String nombre, String nombreUsuario, String contrasenya, int admin) {
			super();
			this.nombre = nombre;
			this.nombreUsuario = nombreUsuario;
			this.contrasenya = contrasenya;
			this.admin = admin;
		}
		public Usuario() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * devuelve el nombre del usuario
		 * @return nombre del usuario
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * Modifica el nombre del usuario
		 * @param nombre el nuevo nombre del usuario 
		 */
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
		public int getAdmin() {
			return admin;
		}
		public void setAdmin(int admin) {
			this.admin = admin;
		}
		@Override
		public String toString() {
			return "Usuario [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasenya=" + contrasenya
					+ ", admin=" + admin + "]";
		}
		

}
