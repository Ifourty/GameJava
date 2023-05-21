/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Position;

import game.GameCompenents.Player;
import game.GameCompenents.Room;
import game.GameCompenents.Wall;

/**
 *
 * @author firer
 */
public class gamePanel extends javax.swing.JPanel {

    private static final int roomSize = 100;
    private static final int wallSize = 5;
    private static final int textSize = 24;
    private int gameLong = 5;
    private static final int playerSize = 25;

    private ArrayList<Room> listRoom;
    private Player p;
    private Room inititalRoom;
    private int positionX = 0;
    private int positionY = 0;
    private int totalNumber;

    private Game superior;

    private boolean gameEnded = false;

    public gamePanel(Game sueprior, int gameLong) {
        initComponents();
        initTouche();
        superior = sueprior;
        this.gameLong = gameLong;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        affichageMang = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));

        affichageMang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        affichageMang.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affichageMang, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affichageMang, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 271, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 258, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel affichageMang;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void initGame() {

        listRoom = new ArrayList<>();
        System.out.println(getWidth());
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        Room traitementRoom = new Room(null, null, null, null, 2);
        /* TOP WALL */
        Wall wallTraitement = new Wall(centerX - roomSize / 2, centerY - roomSize / 2);
        traitementRoom.setTop(wallTraitement);
        /* RIGHT WALL */
        wallTraitement = new Wall(wallTraitement.getPosX() + roomSize, wallTraitement.getPosY());
        traitementRoom.setRight(wallTraitement);
        /* BOTTOM WALL */
        wallTraitement = new Wall(wallTraitement.getPosX() - roomSize, wallTraitement.getPosY() + roomSize);
        traitementRoom.setBottom(wallTraitement);
        /* LEFT WALL */
        wallTraitement = new Wall(wallTraitement.getPosX(), wallTraitement.getPosY() - roomSize);
        traitementRoom.setLeft(wallTraitement);
        listRoom.add(traitementRoom);
        inititalRoom = traitementRoom;
        p = new Player(playerSize, centerX - playerSize / 2, centerY - playerSize / 2, inititalRoom);
        affichageMang.setText("Puissance : " + p.getNb());
        Room inRoom = traitementRoom;
        boolean notBuild = false;
        for (int i = 0; i < gameLong; i++) {
            inRoom = inititalRoom;
            do {
                int random = Double.valueOf(Math.random() * 4).intValue();
                totalNumber = 0;
                for (Room r : listRoom) {
                    totalNumber += r.getNumber();
                }
                int numberToApply = 0;
                while (numberToApply == 0) {
                    numberToApply = Double.valueOf(Math.random() * (totalNumber + 1)).intValue();
                    System.out.println("t");
                }
                numberToApply = numberToApply == 1 || numberToApply == 0 ? 1 : numberToApply - 1;
                notBuild = false;
                switch (random) {
                    case 0:
                        if (inRoom.getTopRoom() == null) {
                            traitementRoom = new Room(null, null, null, null, numberToApply);
                            /* BOTTOM */
                            wallTraitement = new Wall(inRoom.getTop().getPosX(),
                                    inRoom.getTop().getPosY());
                            traitementRoom.setBottom(wallTraitement);
                            /* LEFT && TOP */
                            wallTraitement = new Wall(wallTraitement.getPosX(), wallTraitement.getPosY() - roomSize);
                            traitementRoom.setLeft(wallTraitement);
                            traitementRoom.setTop(wallTraitement);
                            /* RIGHT */
                            wallTraitement = new Wall(wallTraitement.getPosX() + roomSize, wallTraitement.getPosY());
                            traitementRoom.setRight(wallTraitement);

                            checkAround(traitementRoom);
                            listRoom.add(traitementRoom);
                        } else {
                            notBuild = true;
                            inRoom = inRoom.getTopRoom();
                        }
                        break;
                    case 1:
                        if (inRoom.getRightRoom() == null) {
                            traitementRoom = new Room(null, null, null, null, numberToApply);
                            /* LEFT && TOP */
                            wallTraitement = new Wall(inRoom.getRight().getPosX(),
                                    inRoom.getRight().getPosY());
                            traitementRoom.setLeft(wallTraitement);
                            traitementRoom.setTop(wallTraitement);
                            /* BOTTOM */
                            wallTraitement = new Wall(wallTraitement.getPosX(), wallTraitement.getPosY() + roomSize);
                            traitementRoom.setBottom(wallTraitement);

                            /* RIGHT */
                            wallTraitement = new Wall(wallTraitement.getPosX() + roomSize,
                                    wallTraitement.getPosY() - roomSize);
                            traitementRoom.setRight(wallTraitement);

                            checkAround(traitementRoom);
                            listRoom.add(traitementRoom);
                        } else {
                            notBuild = true;
                            inRoom = inRoom.getRightRoom();
                        }
                        break;
                    case 2:
                        if (inRoom.getBottomRoom() == null) {
                            traitementRoom = new Room(null, null, null, null, numberToApply);
                            /* LEFT && TOP */
                            wallTraitement = new Wall(inRoom.getBottom().getPosX(),
                                    inRoom.getBottom().getPosY());
                            traitementRoom.setLeft(wallTraitement);
                            traitementRoom.setTop(wallTraitement);
                            /* BOTTOM */
                            wallTraitement = new Wall(wallTraitement.getPosX(), wallTraitement.getPosY() + roomSize);
                            traitementRoom.setBottom(wallTraitement);

                            /* RIGHT */
                            wallTraitement = new Wall(wallTraitement.getPosX() + roomSize,
                                    wallTraitement.getPosY() - roomSize);
                            traitementRoom.setRight(wallTraitement);

                            checkAround(traitementRoom);
                            listRoom.add(traitementRoom);
                        } else {
                            notBuild = true;
                            inRoom = inRoom.getBottomRoom();
                        }
                        break;
                    case 3:
                        if (inRoom.getLeftRoom() == null) {
                            traitementRoom = new Room(null, null, null, null, numberToApply);
                            /* RIGHT */
                            wallTraitement = new Wall(inRoom.getLeft().getPosX(),
                                    inRoom.getLeft().getPosY());
                            traitementRoom.setRight(wallTraitement);
                            /* BOTTOM */
                            wallTraitement = new Wall(wallTraitement.getPosX() - roomSize,
                                    wallTraitement.getPosY() + roomSize);
                            traitementRoom.setBottom(wallTraitement);

                            /* LEFT && TOP */
                            wallTraitement = new Wall(wallTraitement.getPosX(),
                                    wallTraitement.getPosY() - roomSize);
                            traitementRoom.setTop(wallTraitement);
                            traitementRoom.setLeft(wallTraitement);

                            checkAround(traitementRoom);
                            listRoom.add(traitementRoom);
                        } else {
                            notBuild = true;
                            inRoom = inRoom.getLeftRoom();
                        }
                        break;

                }
            } while (notBuild);
        }
        for (Room r : listRoom) {
            System.out
                    .println(r.getNumber() + " - top :" + r.getTopRoom() + " bottom :" + r.getBottomRoom() + " right :"
                            + r.getRightRoom() + " left :" + r.getLeftRoom());
        }
        totalNumber = 0;
        for (Room r : listRoom) {
            totalNumber += r.getNumber();
        }
        inititalRoom.setNumber(0);
        repaint();
    }

    public void initTouche() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        if (p.getIntRoom().getTopRoom() != null
                                && p.getIntRoom().getTopRoom().getNumber() < p.getNb()) {
                            positionY--;
                            p.setIntRoom(p.getIntRoom().getTopRoom());
                            p.addNb(p.getIntRoom().getNumber());
                            p.getIntRoom().setNumber(0);
                            affichageMang.setText("Puissance : " + p.getNb());
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (p.getIntRoom().getBottomRoom() != null
                                && p.getIntRoom().getBottomRoom().getNumber() < p.getNb()) {
                            positionY++;
                            p.setIntRoom(p.getIntRoom().getBottomRoom());
                            p.addNb(p.getIntRoom().getNumber());
                            p.getIntRoom().setNumber(0);
                            affichageMang.setText("Puissance : " + p.getNb());
                            repaint();
                        }

                        break;
                    case KeyEvent.VK_LEFT:
                        if (p.getIntRoom().getLeftRoom() != null
                                && p.getIntRoom().getLeftRoom().getNumber() < p.getNb()) {
                            positionX--;
                            p.setIntRoom(p.getIntRoom().getLeftRoom());
                            p.addNb(p.getIntRoom().getNumber());
                            p.getIntRoom().setNumber(0);
                            affichageMang.setText("Puissance : " + p.getNb());
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (p.getIntRoom().getRightRoom() != null
                                && p.getIntRoom().getRightRoom().getNumber() < p.getNb()) {
                            positionX++;
                            p.setIntRoom(p.getIntRoom().getRightRoom());
                            p.addNb(p.getIntRoom().getNumber());
                            p.getIntRoom().setNumber(0);
                            affichageMang.setText("Puissance : " + p.getNb());
                            repaint();
                        }
                        break;
                }
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getWidth());
        for (Room r : listRoom) {
            if (r == inititalRoom) {
                g.setColor(Color.cyan);
            } else {
                g.setColor(Color.lightGray);
            }
            g.fillRect(r.getTop().getPosX() - (positionX * roomSize), r.getTop().getPosY() - (positionY * roomSize),
                    r.getRight().getPosX() - r.getTop().getPosX(),
                    r.getBottom().getPosY() - r.getTop().getPosY());

            g.setColor(Color.BLACK);

            g.fillRect(r.getTop().getPosX() - (positionX * roomSize), r.getTop().getPosY() - (positionY * roomSize),
                    roomSize, wallSize);
            g.fillRect(r.getRight().getPosX() - (positionX * roomSize), r.getRight().getPosY() - (positionY * roomSize),
                    wallSize, roomSize);
            g.fillRect(r.getBottom().getPosX() - (positionX * roomSize),
                    r.getBottom().getPosY() - (positionY * roomSize), roomSize, wallSize);
            g.fillRect(r.getLeft().getPosX() - (positionX * roomSize), r.getLeft().getPosY() - (positionY * roomSize),
                    wallSize, roomSize);
            if (r.getNumber() != 0) {
                Font font = new Font("Arial", Font.BOLD, textSize);
                g.setFont(font);
                String number = r.getNumber() < 1000 ? String.valueOf(r.getNumber())
                        : r.getNumber() < 1000000 ? r.getNumber() / 1000 + "K"
                                : r.getNumber() < 1000000000 ? r.getNumber() / 1000000 + "m"
                                        : r.getNumber() / 1000000000 + "M0";
                g.drawString(number, (r.getTop().getPosX() + roomSize / 2 - textSize / 2) - (positionX * roomSize),
                        (r.getTop().getPosY() + roomSize / 2 + textSize / 2) - (positionY * roomSize));
            }

        }
        g.setColor(Color.orange);
        g.fillOval(p.getPosX(), p.getPosY(), p.getSize(),
                p.getSize());

        if (p.getNb() == totalNumber && !gameEnded) {
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "Tu as gagné !", "Félicitations", JOptionPane.INFORMATION_MESSAGE);
            });
            superior.newGame();
            gameEnded = true;
        }
    }

    public void checkAround(Room r) {
        for (Room room : listRoom) {
            if (room.getTop().getPosY() == r.getTop().getPosY() - roomSize
                    && room.getTop().getPosX() == r.getTop().getPosX()) {
                r.setTopRoom(room);
                room.setBottomRoom(r);
                System.out.println(r.getNumber() + " top " + room.getNumber());
            }
            if (room.getTop().getPosY() == r.getTop().getPosY() + roomSize
                    && room.getTop().getPosX() == r.getTop().getPosX()) {
                r.setBottomRoom(room);
                room.setTopRoom(r);
            }
            if (room.getTop().getPosX() == r.getTop().getPosX() + roomSize
                    && room.getTop().getPosY() == r.getTop().getPosY()) {
                r.setRightRoom(room);
                room.setLeftRoom(r);
            }
            if (room.getTop().getPosX() == r.getTop().getPosX() - roomSize
                    && room.getTop().getPosY() == r.getTop().getPosY()) {
                r.setLeftRoom(room);
                room.setRightRoom(r);
            }
        }

    }

    public static int getRoomsize() {
        return roomSize;
    }

    public static int getWallsize() {
        return wallSize;
    }

    public static int getTextsize() {
        return textSize;
    }

    public static int getPlayersize() {
        return playerSize;
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Room getInititalRoom() {
        return inititalRoom;
    }

    public void setInititalRoom(Room inititalRoom) {
        this.inititalRoom = inititalRoom;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Game getSuperior() {
        return superior;
    }

    public void setSuperior(Game superior) {
        this.superior = superior;
    }

    public javax.swing.JLabel getAffichageMang() {
        return affichageMang;
    }

    public void setAffichageMang(javax.swing.JLabel affichageMang) {
        this.affichageMang = affichageMang;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
}
