/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkkikirjasto;

import lukuvinkkikirjasto.controllers.TipController;
import lukuvinkkikirjasto.dao.BasicTipDao;
import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

class ServerRule extends ExternalResource {

    private final int port;
    ConfigurableApplicationContext app;

    public ServerRule(int port) {
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
        this.app = SpringApplication.run(Main.class);
        TipController controller = this.app.getBean(TipController.class);
        controller.setTipDao(new BasicTipDao());
    }

    @Override
    protected void after() {
        app.close();
    }
}
