package osgi.service.printer;

import org.osgi.framework.*;

public class PrinterActivator implements BundleActivator {

	private ServiceRegistration<Printer> serviceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		serviceRegistration = context.registerService(Printer.class, new PrinterImpl(), null);
    	System.out.println("start : printer service");
		System.out.println("starting client");
		installAndStartBundle();
    }

	@Override
    public void stop(BundleContext context) throws Exception {
       	serviceRegistration.unregister();
        System.out.println("stop : printer service");
    }

	private void installAndStartBundle() throws BundleException {
		BundleContext bundlecontext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		Bundle b = bundlecontext.installBundle("file:service-client-1.0.0.jar");
		b.start();
	}

}
