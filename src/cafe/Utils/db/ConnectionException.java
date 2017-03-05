/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import org.apache.log4j.Logger;

/**
 *
 * @author suxarina
 */
public class ConnectionException  extends Exception{
    
    private static final Logger log = Logger.getLogger(ConnectionException.class);
    
    public ConnectionException(String message) {        
//        super(message);
        log.error("Connection cafe error");        
    }

    
}
