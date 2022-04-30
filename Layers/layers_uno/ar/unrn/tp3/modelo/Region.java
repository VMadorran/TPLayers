package ar.unrn.tp3.modelo;

public class Region {
	private String nombre;
	public static String REGION_CONOCIDA_UNO = "Europa";
	public static String REGION_CONOCIDA_DOS = "China";
	public static String REGION_CONOCIDA_TRES = "US";

	public Region(String nombre) throws Exception {
		this.nombre = nombre;
		if (!this.regionesConocidas())
			throw new Exception("Region desconocida. Las conocidas son: China, US, Europa");

	}

	private boolean regionesConocidas() {

		return ((nombre.equals(REGION_CONOCIDA_UNO)) || (nombre.equals(REGION_CONOCIDA_DOS))
				|| (nombre.equals(REGION_CONOCIDA_TRES)));
	}

	protected String nombreDeLaRegion() {
		return this.nombre;
	}
}
