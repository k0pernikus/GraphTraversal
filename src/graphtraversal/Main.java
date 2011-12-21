/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphtraversal;
import java.util.Stack;


/**
 *
 * @author it0-kretph
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void discoverRooms(Room room) {
        System.out.println("I am in room " + room.name);
        room.isVisited = true;

        Room targetRoom = room.getVisitableRoomOrNull();

        if (targetRoom != null) {
            targetRoom.visitedFrom = room;
            System.out.println("I discovered unvisted room " + targetRoom.name);
            discoverRooms(targetRoom);
        } else if (room.visitedFrom != null) {
            System.out.println("Not seeing any more unvisited rooms, going back to "+ room.visitedFrom.name);
            discoverRooms(room.visitedFrom);
        } else {
            System.out.println("Visited all rooms.");
        }
    }

    public static void main(String[] args) {
        Room A = new Room("A");
        Room B = new Room("B");
        Room C = new Room("C");
        Room D = new Room("D");
        Room E = new Room("E");
        Room F = new Room("F");
        Room G = new Room("G");
        Room H = new Room("H");

        A.conectToRoom(B, G, D);
        B.conectToRoom(A, E, F);
        C.conectToRoom(F, H);
        D.conectToRoom(A, F);
        E.conectToRoom(B, G);
        F.conectToRoom(D, C, B);
        G.conectToRoom(E, A);
        H.conectToRoom(C);

        discoverRooms(A);
    }
}
