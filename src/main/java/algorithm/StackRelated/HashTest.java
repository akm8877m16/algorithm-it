/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.StackRelated;

import java.util.HashMap;

/**
 *
 * @author wb-ywh474663
 * @version $Id: HashTest.java, v 0.1 2018Äê12ÔÂ06ÈÕ 18:50 wb-ywh474663 Exp $
 */
public class HashTest {

    public static void main(String[] arg){
        String uid = "2088302454398192";
        int dbPosition = uid.hashCode()%1000;
        System.out.println(dbPosition);
    }

}