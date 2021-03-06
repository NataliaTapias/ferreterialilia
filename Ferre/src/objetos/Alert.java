package objetos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sql.Select;
import vistas.Alerta;

public class Alert {
	public void Alertame() {
		boolean existe=false;
		Select he=new Select();
		ArrayList<Productos> ho=he.Productos();
		Iterator<Productos> nombreIterator = ho.iterator();
		while(nombreIterator.hasNext()){
			Productos elemento = nombreIterator.next();
			int cantida=elemento.getCantidad();
			int limit=elemento.getLimite();
			if(cantida<=limit) {
				existe =true;
			}
		}
		if(existe == true) {
			final Runnable tarea = new Runnable() {
				  public void run() {
				    Alerta ver=new Alerta();
				    ver.setVisible(true);
				  }
				};
				ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
				timer.scheduleAtFixedRate(tarea, 300, 1800, TimeUnit.SECONDS);
		}
	}
}
