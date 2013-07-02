package com.ever.conesic;

import utiles.fonts;
import informacion.info_ponentes;
import informacion.ponentes_model;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class ponentes extends SherlockFragment {
	UITableView tableView;
	ponentes_model datos;
	int[] objeto;
	Intent i;
	String[] data;
	TextView titulo;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tableView = (UITableView) getView().findViewById(R.id.tableView);
		titulo =(TextView) getView().findViewById(R.id.titulo);
		titulo.setText("Lista de Ponentes");
		fonts.cambiarfont_actionbar(getSherlockActivity(), "fonts/ArtistMedium.ttf");
		fonts.cambiarfont(getSherlockActivity(), R.id.titulo, "fonts/ArtistMedium.ttf");
		createList();
		tableView.commit();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("ListFragment", "onCreateView()");
		Log.v("ListContainer", container == null ? "true" : "false");
		Log.v("ListsavedInstanceState", savedInstanceState == null ? "true"
				: "false");
		if (container == null) {
			return null;
		}
		View view = inflater.inflate(R.layout.ponentes, container, false);
		return view;
	}

	private void createList() {
		// ///
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		// //
		// tableView.setOnClickListener(this);
		tableView.addBasicItem(R.drawable.arturo_canez, "Arturo Cánez",
				"Director de Lima Valley");
		tableView.addBasicItem(R.drawable.manuel_bermudez,
				"P.h.D. Manuel Bermúdez",
				"Coor. de Relaciones con America Latina");
		tableView.addBasicItem(R.drawable.kemper_valverde,
				"DR. Nicolás Kemper Valverde", "Prof. Inteligencia Artificial");
		tableView.addBasicItem(R.drawable.roman_gonzales,
				"Mg. Avid Roman Gonzales ",
				"Mg. Automatización Industrial y Humana");
		tableView.addBasicItem(R.drawable.suarez_reymundo,
				"Ing.J.P. Suarez Reymundo", "Influencer de Microsoft PerÃº");
		tableView.addBasicItem(R.drawable.sanchez_rosas,
				"Ing. Juan Sánchez Rosas",
				"Soluciones de Codigo libre y abierto");
		tableView.addBasicItem(R.drawable.pedro_gonzales,
				"Ing. Msc. Pedro A. Gonzales Sanchez",
				"Mestrado em Ciáncias da Comunicação");
		tableView.addBasicItem(R.drawable.rodriguez_rivero,
				"Ing. Cristian Rodriguez Rivero",
				"Computational Intelligence Society (CIS)");
	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			i = new Intent(getSherlockActivity(), info_ponentes.class);
			switch (index) {
			case 0:
				data = new String[] {
						"Arturo Cánez",
						"Director de Lima Valley",
						"http://tarapotoventas.tk/descargas/cv/arturo_canez.pdf",
						"https://www.facebook.com/arturocanez", 
						"https://twitter.com/arturocanez",
						null,
						"http://pe.linkedin.com/in/arturocanez",
						"<html><head><meta charset=utf-8><style type='text/css'>"
								+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2>Empresario con 10 años de experiencia dedicada al " +
								"desarrollo, la creación y la implementación de proyectos basados ​​en la web, con experiencia en agencias de viajes. " +
								"Director de Lima Valley, Co-Founder & Mentor @Startup Academy, Organizer & Advisor " +
								"Startup World, Wayra Perú Mentor Especialidades:el espíritu empresarial, el desarrollo de negocio en Internet, nuevas empresas, marketing " +
								"digital, análisis digital, seo, sem comercio electrónico, innovación, móviles.</br>" +
								"<h2>Experiencia</h2><strong>Co-Fundador</strong></br>Startup Academy LA</br>Startup Academy es un programa que ofrece capacitación modelo de " +
								"negocio y asesoramiento para ayudar a los empresarios en su camino hacia el éxito.<br>" +
								"</br><strong>Director</strong></br>Lima Valley</br>Lima Valley es una organización sin fines de " +
								"lucro en Perú que se centra en el crecimiento de una comunidad que promueve un ambiente emprendedor e " +
								"innovador para el ecosistema de tecnología peruana.</div></body></html>"
						
						};

				// imagenes = icono, img_lista,img_compartir
				objeto = new int[] { R.drawable.arturo_canez,R.drawable.limavalley};
				// coordenadas = new
				// double[]{-6.513434965802698,-76.37042999267578};
				datos = new ponentes_model();
				datos.setData(data);
				datos.setObjeto(objeto);
				// datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 1:
				
				data = new String[] { 
						"Dr. Manuel E. Bermúdez",
						"University of Florida - USA",
						"http://tarapotoventas.tk/descargas/cv/Manuel_Bermudez-CV.pdf",
						null,
						null,
						"manuel@cise.ufl.edu",
						null,
						"<html><head><meta charset=utf-8><style type='text/css'>"
								+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2> Nacido el 21 de " +
								"junio de 1957. Ciudadanos de los EE.UU., los hispanos. Casado y con dos hijos gemelos. Domina el Inglés y Spanish." +
								"Present Posición: Profesor Asociado, PC y Infomation Ciencias e Ingeniería de la Universidad de Florida.</br> " +
								"Tel: (352)-392-1200.</br>Email: manuel@cise.u?.edu.</br> Web: www.cise.u?.edu/˜manuel.</br>" +
								"<h2>Experiencia</h2><strong>— 1996-1997:</strong>Fulbright Scholar visiting en la Universidad de Costa Rica.</br></br>" +
								"<strong>— 2003-2004:</strong>Fulbright Scholar visiting the Universidad de los Andes, Mérida, Venezuela.</br></br>" +
								"<strong>— 2002-present:</strong>Coordinador de Alcance Latinoamericano, Departamento CISE.<br></br>" +
								"<strong>— 2006-2010:</strong>Autor del curso e Instructor, Universidad Tecnológica Nacional Universidad / Walden. Impartido cursos de postgrado en Lenguajes de Programación y Estructuras de Datos Avanzadas." + 
								"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.manuel_bermudez,R.drawable.bermudez};

				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); 
				startActivity(i);
				break;
			case 2:
				// data para armar la vista
				
				data = new String[] { 
				"DR. Nicolás Kemper Valverde",
				"Doctor Inteligencia Artificial",
				"http://tarapotoventas.tk/descargas/cv/nicolas_kemper.pdf", 
				null,
				null,
				null,
				null,
				"<html><head><meta charset=utf-8><style type='text/css'>"
						+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2>Más de 20 años de experiencia realizando proyectos" +
						"de investigación y desarrollo tecnológico. Ha participado como asesor y responsable en muchos proyectos " +
						"relacionados a sistemas inteligentes aplicados con sistemas expertos, lógica difusa, redes neuronales, algoritmos genéticos, razonamiento basado en casos y minería de datos.</br>" +
						"<h2>Experiencia</h2><strong>Grados Obtenidos:</strong></br>- Ingeniero Industrial, especialización en Métodos de Trabajo y Planificación de Operaciones. Universidad Nacional de Trujillo, Perú.</br>" +
						"- Maestría en Ingeniería, especialidad sistemas expertos aplicados en la industria eléctrica, Universidad Nacional Autónoma de México.</br>"+
						"- Doctor en Ingeniería, especialidad en Inteligencia Artificial, Universidad Nacional Autónoma de México."+
						"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.kemper_valverde,R.drawable.nicolaskemper};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			case 3:
				// data para armar la vista
				
				data = new String[] { 
				"Mg. Avid Roman Gonzalez",
				"Mg. Automatización Industrial Humana",
				"http://tarapotoventas.tk/descargas/cv/Avid_Roman.pdf", 
				"https://www.facebook.com/avid.romangonzalez",
				"https://twitter.com/Avid_RG",
				"avid.roman-gonzales@ieee.org",
				"http://pe.linkedin.com/pub/avid-roman-gonzalez/2a/a74/9",
				"<html><head><meta charset=utf-8><style type='text/css'>"
						+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Formación Académica</h2><strong>- 2009 – Actual: </strong> Doctorado en Procesamiento de Señales e Imágenes TELECOM ParisTech – Francia.</br></br>" +
						"<strong>2008 – 2009: </strong> Maestría en Automatización Industrial y Humana Universidad Paul Verlaine de Metz  -  Francia.</br> PRIMER LUGAR DE LA PROMOCIÓN.</br></br>"+
						"<strong>2011 – Actual: </strong> Maestría en Administración y Dirección de Empresas Universidad Alas Peruanas.</br></br>"+
						"<strong>2010 – 2011: </strong> Diplomado en Astronomía y Mecánica Celeste Unidad de Formación y Enseñanza del Observatorio de Paris - Francia.</br></br>"+
						"<h2>Experiencia</h2><strong>INGENIERO INVESTIGADOR  |  Octubre 2012 – Actual</strong></br>TELECOM ParisTech - Francia.</br> - Evaluación de la calidad en imágenes satelitales.</br>" +
						"<strong>INGENIERO INVESTIGADOR  |  Octubre 2009 – Setiembre 2012</strong></br>Centro Nacional de Estudios Espaciales de Francia - CNES.</br> - Evaluación de la calidad en imágenes satelitales. </br>" +
						"<strong>INGENIERO CONSULTOR  |  Julio 2011 – Noviembre 2011</strong></br>SPECTRUM Aerospace Research Corporation</br> - Prueba de radiación a componentes EEE." +
						"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.roman_gonzales,R.drawable.avid};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			
			case 4:
				// data para armar la vista
				
				data = new String[] { 
				"Msc.Ing. J.P. Suarez Reymundo",
				"Mg. Ingenieria con Mención en Gestión de TI",
				"http://tarapotoventas.tk/descargas/cv/JOHN_SUAREZ.pdf", 
				"https://www.facebook.com/johnsuarezr",
				"https://twitter.com/johnsuarezr",
				"johnsuarezr@hotmail.com",
				null,
				"<html><head><meta charset=utf-8><style type='text/css'>"
						+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2>Ingeniero de Sistemas con posgrado en " +
						"Ingeniería de Sistemas con mención en Gestión Tecnologías de información, así mismo en Estrategias Didácticas y Evaluación por  Competencias.</br>" +
						"Expositor en Congresos Nacionales e Internacionales, Líder de comunidades profesionales en desarrollo de software, participa en proyectos en " +
						"instituciones de ámbito científico y empresarial a nivel  internacional.</br>"+
						"<h2>Experiencia</h2>Más de  10 años de experiencia como Influencer de Microsoft Perú, Amplia experiencia como Consultor y Arquitecto de Software, su trabajo está centrado" +
						"en la definición y construcción de soluciones que integran Sistemas Distribuidos. Su pasión se centra en el ambiente Web por lo que es su principal tema de investigación."+
						"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.suarez_reymundo,R.drawable.reymundo};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
				
			case 5:
				// data para armar la vista
				
				data = new String[] { 
				"Ing. Juan Sánchez Rosas",
				"Soluciones de Código libre y abierto",
				"http://tarapotoventas.tk/descargas/cv/Juan_S%C3%A1nchez.pdf", 
				"https://www.facebook.com/juaneladio",
				"https://twitter.com/juaneladio",
				"jesanchez@mozilla.pe",
				"http://pe.linkedin.com/in/juaneladio",
				"<html><head><meta charset=utf-8><style type='text/css'>"
						+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2>Ingeniero Informática egresado de la Pontificia Universidad Católica del " +
						"Perú, es especialista en la investigación e implantación de soluciones de código libre y abierto. Cuenta con experiencia en desarrollo de aplicaciones web, gestión " +
						"de proyectos utilizando metodologías ágiles, además de soporte y capacitación de aplicaciones Open Source.</br>" +
						"<h2>Experiencia</h2><strong>01/2008 - a la fecha: Antartec S.A.C.</strong></br>Cargo: Especialista de soluciones Open Source.</br>" +
						"Investigación, implantación y elaboración de documentación funcional y comercial relacionada a tecnologías colaborativas de nivel empresarial vía Internet.</br></br>" +
						"<strong>01/2010 - 11/2011: Antartec S.A.C.</strong></br></br>Cargo: Jefe de Publicaciones y Web Social " +
						"Definición y gestión de la estrategia de presencia de Antartec en la Web a través del uso de perfiles en medios sociales y los sitios web propios de la empresa.</br></br>"+
						"<strong>05/2009 - 11/2009: Antartec S.A.C.</strong></br></br>Cargo: Líder técnico PHP" +
						"Gestión de proyecto de desarrollo de un sitio web en PHP para 15 países/regiones geográficas, con soporte de roles y flujos de aprobación." +
						"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.sanchez_rosas,R.drawable.eladio};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
				
			case 6:
				// data para armar la vista
				
				data = new String[] { 
				"Ing. Msc. Pedro A. Gonzales Sanchez",
				"Mestrado em Ciência da ComunicaÃ§Ã£o",
				"http://tarapotoventas.tk/descargas/cv/pedro_gonzalez%20-%20cv.pdf", 
				"https://www.facebook.com/pedroantonio.gonzales.9",
				null,
				null,
				null,
				"<html><head><meta charset=utf-8><style type='text/css'>"
						+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Endereço Profissional</h2>Universidad Nacional de San Martín, Facultad de Ingenieria de Sistemas e Informatica.</br></br> " +
						"Rua Maynas 177</br></br> Centro - Tarapoto - Peru</br></br>Telefone:  5142524253 </br> " +
						"<h2>Experiencia</h2><strong>2011</strong></br>Máster en Ciencias de la Comunicación</br>Universidade Federal do Amazonas, UFAM, Manaus, Brasil</br>Título: Aprendendo Funções de Ranking Baseadas em Blocos usando Programação</br>" +
						"Genética, Ano de obtenção: 2013</br>Orientador: David Braga Fernandes</br>Co-orientador: Edleno Moura</br>Bolsista do(a): Consejo Nacional de Desarrollo Científico y Tecnológico" +
						"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.pedro_gonzales,R.drawable.pedro};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			
			case 7:
				// data para armar la vista
				
				data = new String[] { 
				"Ing. Cristian Rodriguez Rivero",
				"Computational Intelligence Society (CIS)",
				"http://tarapotoventas.tk/descargas/cv/Christian%20Rodriguez%20Rivero.pdf", 
				null,
				null,
				"crodriguezrivero@ieee.org",
				"http://ar.linkedin.com/pub/cristian-rodriguez-rivero/18/b6a/74",
				"<html><head><meta charset=utf-8><style type='text/css'>"
						+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2> Recibió el grado de Ingeniería " +
						"Eléctrica de la Facultad de Ciencias Exactas, Físicas y Naturales de la Universidad Nacional de Córdoba, Argentina, en 2007, " +
						"y actualmente se está llevando a cabo el doctorado licenciatura en ingeniería eléctrica en la Universidad Nacional " +
						"de Córdoba, Argentina, bajo la supervisión del Dr. Antonio Julián Pucheta, en el campo del control automático " +
						"de la dinámica de procesos lentos, el control estocástico, optimización y previsión de series temporales.</br>" +
						"<h2>Experiencia</h2><strong>Investigador en LIMAC - FCEFyN</strong></br><strong>Universidad Nacional de Cordoba</strong></br>Institución " +
						"educativa; Más de 10.001 empleados; Sector de Investigación</br>2009 – 2012 (3 años) http://www.inv.limac.efn.uncor.edu/</br></br>" +
						"<strong>Information Programmer</strong></br><strong>HP Enterprise Services</strong></br>Empresa pública; Más de 10.001 empleados; Sector de " +
						"Atención sanitaria y hospitalaria</br>enero de 2009 – junio de 2009 (6 meses)</br></br>" +
						"<strong>Internship</strong></br><strong>Tribunal de Cuentas de la Provincia de Cordoba</strong></br>Agencia gubernamental; De 11 a 50 empleados; " +
						"Sector de Equipos informáticos</br>septiembre de 2006 – enero de 2009 (2 años 5 meses) " +
						"</div></body></html>"
				};
				
				objeto = new int[] { R.drawable.rodriguez_rivero,R.drawable.cristian};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			default:
				break;
			}
		}

	}

}
