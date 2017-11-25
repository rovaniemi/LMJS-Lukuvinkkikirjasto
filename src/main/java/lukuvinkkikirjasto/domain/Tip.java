
package lukuvinkkikirjasto.domain;

public interface Tip {
    boolean markRead();
    
    boolean isRead();
    
    String identify();

    boolean edit(String element, String edit);
}
