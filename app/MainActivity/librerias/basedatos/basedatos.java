package basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class basedatos {

	public static final String ID_FILA = "_id";
	public static final String ID_NOMBRE = "nombre";
	public static final String ID_RANGO = "rango";
	public static final String ID_CATEGORIA = "categoria";
	public static final String ID_COSTO_S = "costo_s";
	public static final String ID_COSTO_D = "costo_d";
	public static final String ID_COSTO_T = "costo_t";
	public static final String ID_COSTO_M = "costo_m";
	public static final String ID_COSTO_C = "costo_c";
	public static final String ID_COSTO_CX = "costo_cx";
	public static final String ID_TELEFONO = "telefono";
	public static final String ID_DIRECCION = "direccion";
	public static final String ID_IMAGEN = "imagen";
	public static final String ID_LATITUD = "latitud";
	public static final String ID_LONGITUD = "longitud";

	private static final String N_BD = "coneisc";
	private static final String N_TABLA = "tabla_hoteles";
	private static final int VERSION_BD = 1;

	private BDHelper nHelper;
	private final Context nContexto;
	private SQLiteDatabase nBD;

	private static class BDHelper extends SQLiteOpenHelper {

		public BDHelper(Context context) {
			super(context, N_BD, null, VERSION_BD);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + N_TABLA + "(" + ID_FILA
					+ " INTEGER PRIMARY KEY, " + ID_NOMBRE
					+ " TEXT, " + ID_RANGO + " TEXT, " + ID_CATEGORIA
					+ " TEXT, " + ID_COSTO_S + " INTEGER, " + ID_COSTO_D
					+ " INTEGER, " + ID_COSTO_T + " INTEGER, " + ID_COSTO_M
					+ " INTEGER, " + ID_COSTO_C + " INTEGER, " + ID_COSTO_CX
					+ " INTEGER, " + ID_TELEFONO + " TEXT, " + ID_DIRECCION
					+ " TEXT, " + ID_IMAGEN + " TEXT, " + ID_LATITUD
					+ " TEXT, " + ID_LONGITUD + " TEXT);");

			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(1, 'Hospedaje las Palmeras', '15-25', 'Hospedaje', 20, 35, 50, null, null, null, '042-525475', 'Jr. Miguel Grau No 229', 'no', '-6.482499899730129', '-76.36476516723633')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(2, 'Alojamiento Melendez', '10-15', 'Alojamiento', 10, 12, null, null, null, null, '042-532468', 'Jr. Pedro de Urzúa No 464', 'no', '-6.489170500783605', '-76.36165112257004')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(3, 'Alojamiento El Mirador', '25-35', 'Alojamiento', 60, 85, 95, 80, 120, null, '042-522177', 'Jr. San Pablo de la Cruz No 517', 'mirador.JPG', '-6.484951748972487', '-76.35613918304443')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(4, 'Alojamiento July', '15-25', 'Alojamiento', 30, 20, 20, null, 20, null, '042-522087', 'Jr. Alegria Arias de Morey No 205 - 219', 'no', '-6.486811948375939', '-76.36075794696808')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(5, 'Alojamiento  San Luis', '15-25', 'Alojamiento', 20, 25, null, 25, null, null, '042-522319', 'Jr. Jimenez Pimentel No 324', 'san_luis.JPG', '-6.4899513524244785', '-76.36152505874634')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(6, 'Alojamiento Miami', '15-25', 'Alojamiento', 30, 45, 55, 40, null, null, '042-523485', 'Jr. Pedro de Urzua No 289', 'no', '-6.490367095466375', '-76.36039853096008')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(7, 'Alojamiento Grau', '15-25', 'Alojamiento', 30, 50, null, 40, null, null, '042-523777', 'Jr. Miguel Grau No 243', 'grau.JPG', '-6.486177669121559', '-76.36070966720581')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(8, 'Hospedaje La Patarashca', '35-50', 'Hospedaje', 65, 105, 135, 105, 170, null, '042-527554 / #782132', 'Jr. San Pablo de la Cruz 362', 'patarashca.JPG', '-6.486092387816401', '-76.35752320289612')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(9, 'Hospedaje El Paso Texas', '15-25', 'Hospedaje', 25, 40, 50, 35, null, null, '042-523799 / *265351 / #784279', 'Jr. Alegria Arias de Morey 115', 'no', '-6.487198378622738', '-76.36139363050461')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(10, 'Alojamiento Luis Fernando ', '25-35', 'Alojamiento', 40, 60, null, 50, null, null, '042-529975', 'Jr. Alegria A. de Morey 247', 'no', '-6.486779967928451', '-76.36091887950897')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(11, 'Hospedaje Miguelito', '15-25', 'Hospedaje', 25, 40, null, 65, null, null, '042-522751', 'Jr. Alfonso Ugarte No. 312 - B', 'no', '-6.4877820209854', '-76.36364936828613')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(12, 'Alojamiento D & F', '15-25', 'Alojamiento', 25, 35, null, null, null, null, ' # 909603', 'Jr. Orellana No. 135', 'no', '-6.490890771309597', '-76.36478662490845')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(13, 'Alojamiento Viajero Wassi', '15-25', 'Alojamiento', 30, 40, 45, 35, null, null, '530368 / 942662015 / #869879 / #949967046', 'Jr. Andres Avelino Caceres No 145', 'no', '-6.485390149020469', '-76.36334896087646')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(14, 'Alojamiento Fernando', '15-25', 'Alojamiento', 20, 40, 50, 30, null, null, '# 972610005 / 942781420', 'Jr. Lima No 299', 'no', '-6.486007106496793', '-76.36504411697388')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(15, 'Alojamiento Oriente', '15-25', 'Alojamiento', null, 20, 20, null, 20, null, '042-522783', 'Jr. Alfonso Ugarte No 154', 'oriente.JPG', '-6.486614735584055', '-76.36221170425415')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(16, 'La Posada del Mirador', '15-25', 'Alojamiento', 25, 40, 60, 35, null, null, '042-527048', 'Jr. Nicolas de Pierola No 381', 'no', '-6.486360224366937', '-76.36524796485901')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(17, 'Hospedaje Trujillano', '15-25', 'Hospedaje', 25, 35, 45, null, null, null, '042-531073 / #325446', 'Jr. Alonso Alvarado No. 444', 'no', '-6.486273610572633', '-76.36584877967834')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(18, 'Hospedaje Gran Chimu', '15-25', 'Hospedaje', 25, 35, 45, null, 55, null, '042-522973', 'Jr. Cahuide No. 396', 'gran_chimu.JPG', '-6.488341677410511', '-76.35686874389648')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(19, 'Hospedaje Costa Verde', '15-25', 'Hospedaje', null, 20, 20, null, 20, null, '042-522854 - 042-527286', 'Jr. Tahuantinsuyo No. 144', 'no', '-6.4883310172939295', '-76.365065574646')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(20, 'Alojamiento San Martín', '15-25', 'Alojamiento', 25, 40, 50, 35, null, null, '042-520147 / *204636', 'Jr. Martinez de Compañon No. 273', 'no', '-6.488789402102947', '-76.36167526245117')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(21, 'Hospedaje Viluz', '15-25', 'Hospedaje', 25, 30, null, 25, null, null, '042-530108 - 042-525281', 'Jr. Cabo Alberto Leveau No 340', 'viluz.JPG', '-6.491135952687701', '-76.36116027832031')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(22, 'Alojamiento y Restaurant Santa Mónica', '15-25', 'Alojamiento', null, 15, 15, null, 15, null, '042-528160 - 042-530481', 'Jr. Alfonso Ugarte No 566', 'no', '-6.489023924402095', '-76.36533379554749')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(23, 'Hosteria Residencial Amazonas', '15-25', 'Hosteria', 35, 45, null, null, null, null, '042-528199', 'Jr. Pedro de Urzua No. 370 - 374', 'amazonas.JPG', '-6.490671573726479', '-76.36026978492737')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(24, 'Hospedaje Misti', '25-35', 'Hospedaje', null, 30, 30, null, 30, null, '042-522439', 'Jr. Leoncio Prado No. 341', 'misti.JPG', '-6.4850810037375135', '-76.36072039604187')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(25, 'Alojamiento Copacabana', '15-25', 'Alojamiento', 35, 45, 55, null, null, null, '971866878 -   042-522301', 'Jr. Jimenez Pimentel No. 324', 'copacabana.JPG', '-6.4899300322592275', '-76.36139631271362')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(26, 'Alojamiento Lima', '15-25', 'Alojamiento', 20, 30, null, null, null, null, '042-523821', 'Jr. Lima No. 769', 'no', '-6.48380577744121', '-76.36748492717743')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(27, 'Alojamiento El Pueblo', '15-25', 'Alojamiento', 20, 25, null, null, null, null, '042-341295', 'Jr. Nicolas de Piérola No. 342', 'no', '-6.485528731327143', '-76.36489391326904')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(28, 'Alojamiento La Siesta', '15-25', 'Alojamiento', 30, 40, 50, null, null, null, '042-521556', 'Jr. Progreso No. 468', 'no', '-6.492757611296594', '-76.3614821434021')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(29, 'Alojamiento Alí', '15-25', 'Alojamiento', 30, 45, 50, 35, null, null, '042-531599', 'Jr. Miguel Grau No. 265', 'ali.JPG', '-6.486468158458994', '-76.36096715927124')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(30, 'Alojamiento La Inolvidable', '15-25', 'Alojamiento', 30, 45, null, null, null, null, '042-341096', 'Jr. Martin de la Riva No.  235', 'no', '-6.484238848384253', '-76.36623501777649')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(31, 'Hospedaje El Encanto', '15-25', 'Hospedaje', 25, 35, 45, 25, null, null, '042-523996 / 042-520011 / #325446', 'Jr. Tahuantinsuyo No. 856', 'no', '-6.483907049448918', '-76.3690459728241')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(32, 'Alojamiento Ahuashiyacu', '15-25', 'Alojamiento', null, 50, 60, null, null, null, '042-521086 / #818145', 'Jr. Martin de la Riva No.  240', 'no', '-6.484420071806925', '-76.36594533920288')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(33, 'Hospedaje El Peregrino', '15-25', 'Hospedaje', 15, 30, null, null, null, null, '042-503459', 'Jr. Tahuantinsuyo Nro 574', 'no', '-6.485751262451392', '-6.485751262451392')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(34, 'Hospedaje El Milenio', '15-25', 'Hospedaje', 50, null, null, 50, null, null, '# 942929090', 'Jr. Lima 267 - 269', 'no', '-6.486689356649517', '-76.36407852172852')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(35, 'Alojamiento La Florida Inn', '15-25', 'Alojamiento', null, 40, null, 30, null, null, '042-523808', 'Jr. Santa Rosa No. 595', 'no', '-6.48713841532801', '-76.36687874794006')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(36, 'Mary House Alojamiento', '15-25', 'Alojamiento', 25, 40, 45, 35, null, null, '042-523260', 'Jr.Alfonso Ugarte Nro 324', 'no', '-6.487941922884585', '-76.36363327503204')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(37, 'Hospedaje Vista Verde', '15-25', 'Hospedaje', 40, 50, null, 60, null, null, '042-528565 / *606946', 'Jr. Ramon Castilla No. 930 - Urb. Los Jardines', 'no', '-6.491990089056291', '-76.36755466461182')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(38, 'Gold Tarapoto Hospedaje', '35-50', 'Hospedaje', null, 100, 120, 80, null, null, '042-521200 /  #941950274 ', 'Jr. Alegria A. de Morey No 251', 'no', '-6.48670001680083', '-76.3608330488205')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(39, 'Heliconias Gran Hospedaje', '25-35', 'Hospedaje', 35, 60, 75, 50, null, null, '042-526526 /942916255', 'Jr. Pedro de Urzua No. 309', 'heliconia.JPG', '-6.490517668983431', '-76.36006593704224')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(40, 'Hospedaje La Novia', '15-25', 'Hospedaje', null, 45, 55, 30, null, null, '# 975731267', 'Jr. Lima Cdra 8 (Jr. Lima 898 - C08)', 'no', '-6.48329941709758', '-76.36870265007019')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(41, 'Hospedaje Sol de Piura', '25-35', 'Hospedaje', 25, null, null, null, null, null, '942009185- 042-530757', 'Jr. Ricardo Palma No. 954', 'no', '-6.494941578768994', '-76.36503338813782')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(42, 'Alojamiento Gran Pajaten', '25-35', 'Alojamiento', 50, 60, 80, 50, null, null, '042-522532', 'Jr. Tahuantinsuyo No. 167', 'no', '-6.488288376825378', '-76.36517286300659')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(43, 'Hospedaje  Turismo Sol y Luna ', '15-25', 'Hospedaje', 25, 40, 60, null, null, null, '042-524703', 'Jr. Nicolas de Pierola No. 529', 'no', '-6.486850591413969', '-76.36565566062927')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(44, 'Morales Beach Alojamiento', '15-25', 'Alojamiento', 25, 40, null, 35, null, null, '042-528151', 'Jr. Alfonso Ugarte No. 247 (Morales)', 'no', '-6.478555595500344', '-76.38247847557068')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(45, 'Riosol Tarapoto Hotel', '60-80', 'Hotel', 105, 140, 170, null, null, null, '042-523154 / 042-523341', 'Jr. Jimenez Pimentel 407', 'riosol.JPG', '-6.490420395831541', '-76.36221170425415')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(46, 'Cerro Verde Tarapoto Hotel', '35-50', 'Hotel', 70, 90, 120, null, null, null, '042-522288', 'Jr. Augusto B. Leguia 596', 'cerro_verde.JPG', '-6.485196933240838', '-76.36417508125305')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(47, 'Hotel Luna Azul', '35-50', 'Hotel', 75, 110, 140, null, null, null, '042-525787', 'Jr. Manco Capac No. 276', 'luna_azul.JPG', '-6.486765310222663', '-76.35666489601135')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(48, 'Hostal Casa Blanca', '25-35', 'Hostal', 40, 60, 90, null, null, null, '042-532380 / *348496', 'Jr. Alegria Arias de Morey No. 399', 'casa_blaca.JPG', '-6.485932485330303', '-76.35999083518982')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(49, 'Hotel Cielo', '35-50', 'Hotel', 55, 86, 120, null, null, null, '042-521012 / 042-525337 / 942697960 / #564254', 'Jr. San Martin No. 334', 'cielo.JPG', '-6.48611370814404', '-76.36227607727051')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(50, 'Hostal Sol de Selva', '35-50', 'Hostal', 50, 80, 100, null, null, null, '042-524817', 'Jr. Pedro de Urzua No. 161', 'no', '-6.491008031983588', '-76.35960459709167')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(51, 'Hotel Rio Cumbaza', '50-60', 'Hotel', 90, 55, null, null, null, null, '042-521473 - 042-521491 / #883475', 'Jr. Pedro de Urzua No. 515', 'rio_cumbaza.JPG', '-6.488598852654505', '-76.36199712753296')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(52, 'Hotel Cumbaza', '50-60', 'Hotel', 80, 120, 150, null, null, null, '042-525152', 'Jr. Jimenez Pimentel 610', 'cumbaza.JPG', '-6.491401121543799', '-76.36330604553223')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(53, 'Hotel Tarapoto Inn', '25-35', 'Hotel', 50, 65, 110, null, 130, null, '042-524213 / 942870736 / #440703 ', 'Jr. Jimenez Pimentel No. 115', 'tarapoto inn.JPG', '-6.488757421780964', '-76.36006593704224')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(54, 'Hotel Nilas', '50-60', 'Hotel', 80, 120, 160, null, 200, null, '042-527331 / 042-527332', 'Jr. Moyobamba 173', 'nilas.JPG', '-6.488023206330544', '-76.35886430740356')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(55, 'Hostal Marbella', '15-25', 'Hostal', 40, 60, null, null, null, 120, '042-531828 / #0079098  / *829890', 'Jr. Augusto B. Leguia 509', 'marbella.JPG', '-6.485559379332124', '-76.36419653892517')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(56, 'Pacifico Tarapoto Hotel', '25-35', 'Hotel', null, 30, 30, null, null, null, '042-525595 / 042-522169 / #911626', 'Jr. Gregorio Delgado No. 158', 'no', '-6.488844035148297', '-76.36099934577942')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(57, 'Hostal Victor Manuel', '25-35', 'Hostal', 35, 55, 75, null, null, null, '042-529945', 'Jr. Ramon Castilla No. 266', 'no', '-6.487857308135932', '-76.3623833656311')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(58, 'Tarapoto Hotel and Suites', '35-50', 'Hotel', 60, 90, 120, null, null, null, '042-528080', 'Jr. Jimenez Pimentel No. 1215', 'no', '-6.4963793410777075', '-76.36806964874268')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(59, 'Hotel Boca Raton', '50-60', 'Hotel', 80, 130, 160, 120, 200, null, '042-531226 / #400855/ #400885 / #401727', 'Jr. Miguel Grau No. 151', 'boca_raton.JPG', '-6.48696652051022', '-76.36032342910767')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(60, 'Hotel San Antonio', '15-25', 'Hotel', 35, 45, null, 50, null, null, '042-522226', 'Jr. Jimenez Pimentel 126', 'san_antonio.JPG', '-6.488853362740809', '-76.36015176773071')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(61, 'Hotel Monte Azul', '35-50', 'Hotel', 50, 80, 120, null, null, null, '042-522443', 'Jr. Camila Morey No. 156', 'monte_azul.JPG', '-6.485506078452688', '-76.3619327545166')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(62, 'Hotel Firenze', '25-35', 'Hotel', 50, 60, 80, null, null, null, '042-525645 / #0412855 ', 'Jr. Aviacion No. 166', 'no', '-6.481957559727581', '-76.37845516204834')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(63, 'Hostal Santa Rosa', '35-50', 'Hostal', 40, 70, null, null, null, null, '042-521065 / #701436', 'Av. Peru No. 365', 'no', '-6.477875999427299', '-76.38671636581421')");
			db.execSQL("INSERT INTO "+ N_TABLA+ " VALUES(64, 'Hostal La Posada Inn', '50-60', 'Hostal', 60, 120, 180, null, null, null, '042-522234 / #606512/ #596753 / #606511 ', 'Jr. San Martin 146', 'no', '-6.487286324775443', '-76.36084377765656')");
	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + N_TABLA);
			onCreate(db);
		}

	}

	public basedatos(Context c) {
		nContexto = c;
	}

	// metodo para abrir nuestra base de datos
	public basedatos abrir() throws Exception {
		nHelper = new BDHelper(nContexto);
		nBD = nHelper.getReadableDatabase();
		return this;
	}

	public void cerrar() {
		nHelper.close();
	}

/*	public long insertar(Integer id, Integer alarma, Integer evento) {
		ContentValues newValues = new ContentValues();
		newValues.put(ID_FILA, id);
		// newValues.put(ID_ESTADO, alarma);
		// newValues.put(ID_VECES, evento);
		return nBD.insert(N_TABLA, null, newValues);
	}
*/
/*	public String seleccionarCategoria() {
		// TODO Auto-generated method stub
		String resultado = "";
		String[] columna = new String[] { ID_CATEGORIA};
		Cursor c = nBD.query(N_TABLA, columna, null, null, null, null, null);

		int iFila = c.getColumnIndex(ID_FILA);
		//int iestado = c.getColumnIndex(ID_ESTADO);
		//int iveces = c.getColumnIndex(ID_VECES);
		// resultado = new int[3];
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			resultado = c.getInt(iFila) + " - " + c.getInt(iestado) + " - "
					+ c.getInt(iveces);
		}
		return resultado;
	}

	// metodos para busqueda
	public int getEstado(long id) {
		String[] columna = new String[] { ID_FILA, ID_ESTADO, ID_VECES };
		Cursor c = nBD.query(N_TABLA, columna, ID_FILA + "=" + id, null, null,
				null, null);
		if (c != null) {
			c.moveToFirst();
			int estado = c.getInt(c.getColumnIndex(ID_ESTADO));
			return estado;
		}
		return (Integer) null;
	}

	public int getVeces(long id) {
		String[] columna = new String[] { ID_FILA, ID_ESTADO, ID_VECES };
		Cursor c = nBD.query(N_TABLA, columna, ID_FILA + "=" + id, null, null,
				null, null);
		if (c != null) {
			c.moveToFirst();
			int veces = c.getInt(2);
			return veces;
		}
		return (Integer) null;

	}

	//
/*	public boolean actualizar(Integer _rowIndex, Integer estado, Integer veces) {
		ContentValues newValues = new ContentValues();
		newValues.put(ID_ESTADO, estado);
		newValues.put(ID_VECES, veces);
		return nBD.update(N_TABLA, newValues, ID_FILA + "=" + _rowIndex, null) > 0;
	}*/
}
