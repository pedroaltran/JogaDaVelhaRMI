import java.awt.Image;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaJogador extends javax.swing.JFrame {

    private int id;
    private JogoDaVelhaServidorInterface servidor;
    private ImageIcon imagemBotao;
    private ImageIcon imagemBotaoAdversario;
    private int tabuleiro[][];

    public TelaJogador() {
        initComponents();
        tabuleiro = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = 9;
            }
        }
        this.setVisible(true);
    }

    public void setJogadaAdversario(int idAdversario, int linha, int coluna) {
        tabuleiro[linha][coluna] = idAdversario;
    }


    public void setId(int id) {
        this.id = id;
        this.setImagemBotoes(id);
        this.desabilitarBotoesJogador();
    }

    public void setServidor(JogoDaVelhaServidorInterface servidor) {
        this.servidor = servidor;
    }

    public void setImagemBotoes(int id) {
        //if(id == 0) {
        //imagemBotoes = Toolkit.getDefaultToolkit().getImage("imagens/O.jpg");

        //} 
        imagemBotao = new ImageIcon(getClass().getClassLoader().getResource("img/O.png"));
        imagemBotaoAdversario = new ImageIcon(getClass().getClassLoader().getResource("img/X.png"));
    }

    public void desabilitarBotoesJogador() {
        linha0Coluna0.setEnabled(false);
        linha0Coluna1.setEnabled(false);
        linha0Coluna2.setEnabled(false);
        linha1Coluna0.setEnabled(false);
        linha1Coluna1.setEnabled(false);
        linha1Coluna2.setEnabled(false);
        linha2Coluna0.setEnabled(false);
        linha2Coluna1.setEnabled(false);
        linha2Coluna2.setEnabled(false);
    }

    public void habilitarBotoesJogador() {
        if (tabuleiro[0][0] == 9) {
            linha0Coluna0.setEnabled(true);
        } else {
            linha0Coluna0.setEnabled(false);
            if (tabuleiro[0][0] == 0) {
                linha0Coluna0.setIcon(imagemBotao);
            } else {
                linha0Coluna0.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[0][1] == 9) {
            linha0Coluna1.setEnabled(true);
        } else {
            linha0Coluna1.setEnabled(false);
            if (tabuleiro[0][1] == 0) {
                linha0Coluna1.setIcon(imagemBotao);
            } else {
                linha0Coluna1.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[0][2] == 9) {
            linha0Coluna2.setEnabled(true);
        } else {
            linha0Coluna2.setEnabled(false);
            if (tabuleiro[0][2] == 0) {
                linha0Coluna2.setIcon(imagemBotao);
            } else {
                linha0Coluna2.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[1][0] == 9) {
            linha1Coluna0.setEnabled(true);
        } else {
            linha1Coluna0.setEnabled(false);
            if (tabuleiro[1][0] == 0) {
                linha1Coluna0.setIcon(imagemBotao);
            } else {
                linha1Coluna0.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[1][1] == 9) {
            linha1Coluna1.setEnabled(true);
        } else {
            linha1Coluna1.setEnabled(false);
            if (tabuleiro[1][1] == 0) {
                linha1Coluna1.setIcon(imagemBotao);
            } else {
                linha1Coluna1.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[1][2] == 9) {
            linha1Coluna2.setEnabled(true);
        } else {
            linha1Coluna2.setEnabled(false);
            if (tabuleiro[1][2] == 0) {
                linha1Coluna2.setIcon(imagemBotao);
            } else {
                linha1Coluna2.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[2][0] == 9) {
            linha2Coluna0.setEnabled(true);
        } else {
            linha2Coluna0.setEnabled(false);
            if (tabuleiro[2][0] == 0) {
                linha2Coluna0.setIcon(imagemBotao);
            } else {
                linha2Coluna0.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[2][1] == 9) {
            linha2Coluna1.setEnabled(true);
        } else {
            linha2Coluna1.setEnabled(false);
            if (tabuleiro[2][1] == 0) {
                linha2Coluna1.setIcon(imagemBotao);
            } else {
                linha2Coluna1.setIcon(imagemBotaoAdversario);
            }
        }
        if (tabuleiro[2][2] == 9) {
            linha2Coluna2.setEnabled(true);
        } else {
            linha2Coluna2.setEnabled(false);
            if (tabuleiro[2][2] == 0) {
                linha2Coluna2.setIcon(imagemBotao);
            } else {
                linha2Coluna2.setIcon(imagemBotaoAdversario);
            }
        }
    }

    public JTextField getCampoInstrucoes() {
        return campoIntrucoes;
    }
    
    public void setPlacar(String placar){
    	campoPlacar.setText(placar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	TelaJogador frame = this;
        planoDeFundo = new javax.swing.JPanel();
        painelInstrucoesJogo = new javax.swing.JPanel();
        campoIntrucoes = new javax.swing.JTextField();
        painelPlacarJogo = new javax.swing.JPanel();
        campoPlacar = new javax.swing.JTextField();
        painelTabuleiroJogo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        linha0Coluna0 = new javax.swing.JButton();
        linha1Coluna0 = new javax.swing.JButton();
        linha2Coluna0 = new javax.swing.JButton();
        linha0Coluna1 = new javax.swing.JButton();
        linha1Coluna1 = new javax.swing.JButton();
        linha2Coluna1 = new javax.swing.JButton();
        linha0Coluna2 = new javax.swing.JButton();
        linha1Coluna2 = new javax.swing.JButton();
        linha2Coluna2 = new javax.swing.JButton();
        barraDeMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuConfiguracao = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Deseja mesmo sair?", "Saindo?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
//                    System.exit(0);
                	try {
                        servidor.jogar(id, -1, -1);
                    } catch (RemoteException ex) {
                    	System.exit(0);
//                        Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        
        painelPlacarJogo.setBorder(javax.swing.BorderFactory.createTitledBorder("Placar"));
        painelPlacarJogo.setName("Placar do Jogo"); // NOI18N

        campoPlacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIntrucoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPlacarJogoLayout = new javax.swing.GroupLayout(painelPlacarJogo);
        painelPlacarJogo.setLayout(painelPlacarJogoLayout);
        painelPlacarJogoLayout.setHorizontalGroup(
        		painelPlacarJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPlacarJogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPlacar)
                .addContainerGap())
        );
        painelPlacarJogoLayout.setVerticalGroup(
        		painelPlacarJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPlacarJogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPlacar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        painelInstrucoesJogo.setBorder(javax.swing.BorderFactory.createTitledBorder("Instruções"));
        painelInstrucoesJogo.setName("Instruções do Jogo"); // NOI18N

        campoIntrucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIntrucoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelInstrucoesJogoLayout = new javax.swing.GroupLayout(painelInstrucoesJogo);
        painelInstrucoesJogo.setLayout(painelInstrucoesJogoLayout);
        painelInstrucoesJogoLayout.setHorizontalGroup(
            painelInstrucoesJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInstrucoesJogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoIntrucoes)
                .addContainerGap())
        );
        painelInstrucoesJogoLayout.setVerticalGroup(
            painelInstrucoesJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInstrucoesJogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoIntrucoes, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelTabuleiroJogo.setBorder(javax.swing.BorderFactory.createTitledBorder("Jogo da Velha"));

        jPanel1.setBackground(new java.awt.Color(63, 126, 52));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 400));

        linha0Coluna0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha0Coluna0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha0Coluna0ActionPerformed(evt);
            }
        });

        linha1Coluna0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha1Coluna0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha1Coluna0ActionPerformed(evt);
            }
        });

        linha2Coluna0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha2Coluna0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha2Coluna0ActionPerformed(evt);
            }
        });

        linha0Coluna1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha0Coluna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha0Coluna1ActionPerformed(evt);
            }
        });

        linha1Coluna1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha1Coluna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha1Coluna1ActionPerformed(evt);
            }
        });

        linha2Coluna1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha2Coluna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha2Coluna1ActionPerformed(evt);
            }
        });

        linha0Coluna2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha0Coluna2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha0Coluna2ActionPerformed(evt);
            }
        });

        linha1Coluna2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha1Coluna2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha1Coluna2ActionPerformed(evt);
            }
        });

        linha2Coluna2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linha2Coluna2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linha2Coluna2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(linha2Coluna0, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linha1Coluna0, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linha0Coluna0, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(linha1Coluna1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linha1Coluna2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(linha2Coluna1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linha2Coluna2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(linha0Coluna1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linha0Coluna2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linha0Coluna2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linha0Coluna1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linha0Coluna0, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(linha1Coluna1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(linha1Coluna0, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(linha1Coluna2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linha2Coluna0, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linha2Coluna1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linha2Coluna2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelTabuleiroJogoLayout = new javax.swing.GroupLayout(painelTabuleiroJogo);
        painelTabuleiroJogo.setLayout(painelTabuleiroJogoLayout);
        painelTabuleiroJogoLayout.setHorizontalGroup(
            painelTabuleiroJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabuleiroJogoLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        painelTabuleiroJogoLayout.setVerticalGroup(
            painelTabuleiroJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabuleiroJogoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout planoDeFundoLayout = new javax.swing.GroupLayout(planoDeFundo);
        planoDeFundo.setLayout(planoDeFundoLayout);
        planoDeFundoLayout.setHorizontalGroup(
            planoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planoDeFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(planoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                	.addComponent(painelPlacarJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)	
                    .addComponent(painelInstrucoesJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTabuleiroJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        planoDeFundoLayout.setVerticalGroup(
            planoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planoDeFundoLayout.createSequentialGroup()
            		.addComponent(painelPlacarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                .addComponent(painelInstrucoesJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelTabuleiroJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        menuArquivo.setText("Arquivo");
        barraDeMenu.add(menuArquivo);

        menuConfiguracao.setText("Configuração");
        barraDeMenu.add(menuConfiguracao);

        menuSobre.setText("Sobre");
        barraDeMenu.add(menuSobre);
        setJMenuBar(barraDeMenu);
        campoPlacar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planoDeFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(planoDeFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void linha0Coluna0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha0Coluna0ActionPerformed
        tabuleiro[0][0] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 0, 0);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha0Coluna0ActionPerformed

    private void linha0Coluna2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha0Coluna2ActionPerformed
        tabuleiro[0][2] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 0, 2);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha0Coluna2ActionPerformed

    private void linha2Coluna0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha2Coluna0ActionPerformed
        tabuleiro[2][0] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 2, 0);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha2Coluna0ActionPerformed

    private void campoIntrucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIntrucoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIntrucoesActionPerformed

    private void linha0Coluna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha0Coluna1ActionPerformed
        tabuleiro[0][1] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 0, 1);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha0Coluna1ActionPerformed

    private void linha1Coluna0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha1Coluna0ActionPerformed
        tabuleiro[1][0] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 1, 0);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha1Coluna0ActionPerformed

    private void linha1Coluna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha1Coluna1ActionPerformed
        tabuleiro[1][1] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 1, 1);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha1Coluna1ActionPerformed

    private void linha1Coluna2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha1Coluna2ActionPerformed
        tabuleiro[1][2] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 1, 2);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha1Coluna2ActionPerformed

    private void linha2Coluna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha2Coluna1ActionPerformed
        tabuleiro[2][1] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 2, 1);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha2Coluna1ActionPerformed

    private void linha2Coluna2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linha2Coluna2ActionPerformed
        tabuleiro[2][2] = this.id;
        habilitarBotoesJogador();
        desabilitarBotoesJogador();
        try {
            servidor.jogar(id, 2, 2);
        } catch (RemoteException ex) {
            Logger.getLogger(TelaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linha2Coluna2ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogador().setVisible(true);
            }
        });
    }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JTextField campoIntrucoes;
    private javax.swing.JTextField campoPlacar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton linha0Coluna0;
    private javax.swing.JButton linha0Coluna1;
    private javax.swing.JButton linha0Coluna2;
    private javax.swing.JButton linha1Coluna0;
    private javax.swing.JButton linha1Coluna1;
    private javax.swing.JButton linha1Coluna2;
    private javax.swing.JButton linha2Coluna0;
    private javax.swing.JButton linha2Coluna1;
    private javax.swing.JButton linha2Coluna2;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuConfiguracao;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JPanel painelInstrucoesJogo;
    private javax.swing.JPanel painelPlacarJogo;
    private javax.swing.JPanel painelTabuleiroJogo;
    private javax.swing.JPanel planoDeFundo;
    // End of variables declaration//GEN-END:variables
}