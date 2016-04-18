import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.List;
import java.awt.Point;

public class Pharmacogenomique_UL extends JFrame {
	// définir vos variables de classe ici
	Statement stmt;

	private final JPanel contentPane = new JPanel();
	private final JLabel Jlabel_Etude = new JLabel("\u00C9tude");
	private final JScrollPane scrollPaneEtude = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	private final JLabel lblNo_Etude = new JLabel("No \u00C9tude");
	private final JLabel lblNo_drogue = new JLabel("No Drogue");
	private final JLabel lblNomDrogue = new JLabel("Nom Drogue");
	private final JButton btnGo = new JButton("GO");
	private final JTextField textEtude = new JTextField();
	private final JTextField textNoDrogue = new JTextField();
	private final JTextField textNomDrogue = new JTextField();
	private final JLabel lblVariant = new JLabel("No Variant");
	private final JLabel lblGne = new JLabel("G\u00E8ne");
	private final JTextField textNoVariant = new JTextField();
	private final JTextField textGene = new JTextField();
	private final JLabel lblPatients = new JLabel("Patients");
	private final JLabel lblProvince = new JLabel("Province");
	private final JLabel lblIndiceDfficacitMtabolique = new JLabel("Indice d'\u00E9fficacit\u00E9 m\u00E9tabolique");
	private final JScrollPane scrollPanePatients = new JScrollPane();
	private final JTextArea textArea_1 = new JTextArea();
	private final JButton btnRechercher = new JButton("Rechercher");
	private final JButton btnAnnuler = new JButton("Annuler");
	private final JButton btnAllerSurDrugbank = new JButton("Aller sur DrugBank");
	private final JButton btnIndicefficacitMtabolique = new JButton("Indice \u00E9fficacit\u00E9 m\u00E9tabolique");
	private final JButton btnNouveauPatient = new JButton("Nouveau Patient");
	private final JButton btnSupprimerPatient = new JButton("Supprimer Patient");
	private final JButton btnModifierPatient = new JButton("Modifier Patient");
	private final JButton btnQuitter = new JButton("Quitter");

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Pharmacogenomique_UL frame = new Pharmacogenomique_UL();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Pharmacogenomique_UL() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 486);
		try {
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			Jlabel_Etude.setBounds(10, 11, 56, 14);
			contentPane.add(Jlabel_Etude);

			scrollPaneEtude.setBounds(10, 25, 381, 110);
			contentPane.add(scrollPaneEtude);

			scrollPaneEtude.setViewportView(textArea);
			textArea.setEnabled(false);
			textArea.setText("");

			lblNo_Etude.setBounds(10, 146, 56, 14);
			contentPane.add(lblNo_Etude);

			lblNo_drogue.setBounds(10, 171, 75, 14);
			contentPane.add(lblNo_drogue);

			lblNomDrogue.setBounds(10, 196, 86, 14);
			contentPane.add(lblNomDrogue);

			textEtude.setBounds(95, 143, 91, 20);
			contentPane.add(textEtude);
			textEtude.setColumns(10);
			textEtude.setEnabled(false);

			btnGo.setBounds(195, 143, 91, 20);
			contentPane.add(btnGo);
			btnGo.setEnabled(false);

			textNoDrogue.setBounds(95, 168, 91, 20);
			contentPane.add(textNoDrogue);
			textNoDrogue.setColumns(10);
			textNoDrogue.setEnabled(false);

			textNomDrogue.setBounds(95, 193, 91, 20);
			contentPane.add(textNomDrogue);
			textNomDrogue.setColumns(10);
			textNomDrogue.setEnabled(false);

			lblVariant.setBounds(207, 171, 75, 14);
			contentPane.add(lblVariant);

			lblGne.setBounds(381, 171, 61, 14);
			contentPane.add(lblGne);

			textNoVariant.setBounds(285, 168, 75, 20);
			contentPane.add(textNoVariant);
			textNoVariant.setColumns(10);
			textNoVariant.setEnabled(false);

			textGene.setBounds(423, 168, 135, 20);
			contentPane.add(textGene);
			textGene.setColumns(10);
			textGene.setEnabled(false);

			lblPatients.setBounds(10, 278, 56, 14);
			contentPane.add(lblPatients);

			lblProvince.setBounds(110, 278, 61, 14);
			contentPane.add(lblProvince);

			lblIndiceDfficacitMtabolique.setBounds(203, 278, 188, 14);
			contentPane.add(lblIndiceDfficacitMtabolique);

			scrollPanePatients.setBounds(10, 303, 570, 106);
			contentPane.add(scrollPanePatients);

			scrollPanePatients.setViewportView(textArea_1);
			textArea_1.setEnabled(false);
			textArea_1.setText("");

			btnRechercher.setBounds(433, 39, 104, 23);
			contentPane.add(btnRechercher);
			btnRechercher.setEnabled(false);

			btnAnnuler.setBounds(433, 88, 104, 23);
			contentPane.add(btnAnnuler);
			btnAnnuler.setEnabled(false);

			btnAllerSurDrugbank.setBounds(196, 205, 150, 23);
			contentPane.add(btnAllerSurDrugbank);
			btnAllerSurDrugbank.setEnabled(false);

			btnIndicefficacitMtabolique.setBounds(366, 205, 214, 23);
			contentPane.add(btnIndicefficacitMtabolique);
			btnIndicefficacitMtabolique.setEnabled(false);

			btnNouveauPatient.setBounds(28, 244, 143, 23);
			contentPane.add(btnNouveauPatient);
			btnNouveauPatient.setEnabled(false);

			btnSupprimerPatient.setBounds(207, 244, 156, 23);
			contentPane.add(btnSupprimerPatient);
			btnSupprimerPatient.setEnabled(false);

			btnModifierPatient.setBounds(391, 244, 146, 23);
			contentPane.add(btnModifierPatient);
			btnModifierPatient.setEnabled(false);

			btnQuitter.setBounds(491, 414, 89, 23);
			contentPane.add(btnQuitter);

			String login = "";// vous pouvez écrire directement le login ici et
								// ne pas poser la question juste après
			String passwd = "";// vous pouvez écrire directement le mot de passe
								// ici et ne pas poser la question juste après

			login = JOptionPane.showInputDialog("Quel est le nom de l\'utilisateur?");
			passwd = JOptionPane.showInputDialog("Quel est le mot de passe?");

			// 1-initialisation de la connexion.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@ift-oracle2k3.fsg.ulaval.ca:1521:ora11g",
					login, passwd);
			// 2-Création de la requête pour envoie de l'instruction.
			stmt = con.createStatement();

			// soit Insert, Update or Delete comme requete_sql.
			// stmt.executeUpdate(requete_sql);

			// les requêtes SQL DML qui retournent des données
			ResultSet rsEtude = stmt.executeQuery("select NO_ETUDE, TITRE_ET from TP_2_ETUDE");

			if (rsEtude.next()) {

				String etude = "";

				do {
					etude += rsEtude.getString(1);
					etude += "      ";
					etude += rsEtude.getString(2);
					etude += "\n";
				} while (rsEtude.next());

				String premierNoEtude[] = etude.split("      ", 2);
				if (premierNoEtude[0] != "") {
					btnRechercher.setEnabled(true);
					btnAnnuler.setEnabled(true);
					textEtude.setEnabled(true);
					textEtude.setText(premierNoEtude[0]);
					btnGo.setEnabled(true);
					textArea.setEnabled(true);
					textArea_1.setEnabled(true);
				}

				textArea.setText(etude);
			}

		} catch (Throwable e) {
			textArea.setForeground(Color.RED);
			if (e.getMessage().indexOf("invalid username/password") > 0) {
				textArea.setText("La combinaison mot de passe usager est invalide\nFermez le programme et recommencez");
			} else
			// Pour toutes les autres erreur qu'on ne gère pas, on affiche le
			// message anglais
			{
				textArea.setText(e.getMessage());
			}
		}

		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAllerSurDrugbank.setEnabled(true);
				btnIndicefficacitMtabolique.setEnabled(true);
				btnModifierPatient.setEnabled(true);
				btnNouveauPatient.setEnabled(true);
				btnSupprimerPatient.setEnabled(true);
				textNoDrogue.setEnabled(true);
				textNomDrogue.setEnabled(true);
				textNoVariant.setEnabled(true);
				textGene.setEnabled(true);
				textNoDrogue.setText("");
				textNomDrogue.setText("");
				textNoVariant.setText("");
				textGene.setText("");

				try {
					String goNoDrogue = "";
					goNoDrogue += "select NO_DROGUE from TP_2_ETUDE where NO_ETUDE = \'" + textEtude.getText() + "\'";
					ResultSet rsGoNoDrogue = stmt.executeQuery(goNoDrogue);
					if (rsGoNoDrogue.next()) {
						textNoDrogue.setText(rsGoNoDrogue.getString(1));
					}
					String goNomDrogue = "";
					goNomDrogue += "select NOM_DRO from TP_2_DROGUE where NO_DROGUE = \'" + textNoDrogue.getText()
							+ "\'";
					ResultSet rsGoNomDrogue = stmt.executeQuery(goNomDrogue);
					if (rsGoNomDrogue.next()) {
						textNomDrogue.setText(rsGoNomDrogue.getString(1));
					}
					String goNoVariant = "";
					goNoVariant += "select NO_VAR_GEN from TP_2_DROGUE_VARIANT where NO_DROGUE = \'"
							+ textNoDrogue.getText() + "\'";
					ResultSet rsGoNoVariant = stmt.executeQuery(goNoVariant);
					if (rsGoNoVariant.next()) {
						textNoVariant.setText(rsGoNoVariant.getString(1));
					}
					String goGene = "";
					goGene += "select GENE_VAR from TP_2_VARIATION_GENETIQUE where NO_VARIANT_GENETIQUE = \'"
							+ textNoVariant.getText() + "\'";
					ResultSet rsGoGene = stmt.executeQuery(goGene);
					if (rsGoGene.next()) {
						textGene.setText(rsGoGene.getString(1));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEtude.setText("test");
				textGene.setEnabled(false);
				textGene.setText("");
				textNoDrogue.setEnabled(false);
				textNoDrogue.setText("");
				textNomDrogue.setEnabled(false);
				textNomDrogue.setText("");
				textNoVariant.setEnabled(false);
				textNoVariant.setText("");
				btnAllerSurDrugbank.setEnabled(false);
				btnAnnuler.setEnabled(false);
				btnGo.setEnabled(false);
				btnIndicefficacitMtabolique.setEnabled(false);
				btnModifierPatient.setEnabled(false);
				btnNouveauPatient.setEnabled(false);
				btnRechercher.setEnabled(false);
				btnSupprimerPatient.setEnabled(false);
				textArea.setEnabled(false);
				textArea.setText("");
				textArea_1.setEnabled(false);
				textArea_1.setText("");
				try {
					ResultSet rsEtude = stmt.executeQuery("select NO_ETUDE, TITRE_ET from TP_2_ETUDE");

					if (rsEtude.next()) {

						String etude = "";

						do {
							etude += rsEtude.getString(1);
							etude += "      ";
							etude += rsEtude.getString(2);
							etude += "\n";
						} while (rsEtude.next());

						String premierNoEtude[] = etude.split("      ", 2);
						if (premierNoEtude[0] != "") {
							btnRechercher.setEnabled(true);
							btnAnnuler.setEnabled(true);
							textEtude.setEnabled(true);
							textArea.setEnabled(true);
							textArea_1.setEnabled(true);
							textEtude.setText(premierNoEtude[0]);
							btnGo.setEnabled(true);
						}

						textArea.setText(etude);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnAllerSurDrugbank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Il faut mettre l’URL dans un String
					String drugbankSql = "";
					drugbankSql += "select URL_DRO from TP_2_DROGUE where NO_DROGUE = \'" + textNoDrogue.getText()
							+ "\'";
					String url = "";
					try {
						ResultSet rsDB = stmt.executeQuery(drugbankSql);
						if (rsDB.next()) {
							url = rsDB.getString(1);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					// La ligne ci-haut va ouvrir le navigateur par défaut à
					// l’URL spécifiée
				} catch (java.io.IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});

		btnIndicefficacitMtabolique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String indiceEff = "";
					indiceEff += "select FCT_AVG_INDICE_METABO(NO_ETUDE)from TP_2_ETUDE where NO_ETUDE = \'"
							+ textEtude.getText() + "\'";
					ResultSet rsIndice = stmt.executeQuery(indiceEff);
					if (rsIndice.next()) {
						JOptionPane.showMessageDialog(null,
								"La moyenne des indices d'efficacit\u00E9 m\u00E9tabolique de l\'\u00E9tude \'"
										+ textEtude.getText() + "\' est " + rsIndice.getString(1));
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnModifierPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNouveauPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String noPatient = "";
				String province = "";
				String indiceEff = "";
				String provincePossible[] = { "Alberta", "Colombie-Britannique", "Ile-du-Prince-Edouard", "Manitoba",
						"Nouveau-Brunswick", "Nouvelle-Ecosse", "Ontario", "Quebec", "Saskatchewan",
						"Terre-Neuve-et-Labrador" };
				noPatient = JOptionPane.showInputDialog("Quel est le num\u00E9ro du patient?");
				province = JOptionPane.showInputDialog("Quel est la province de ce patient?");
				indiceEff = JOptionPane.showInputDialog("Quel est l\'indice d\'\u00E9fficacit\u00E9 de ce patient?");
				if (noPatient != null && province != null && indiceEff != null) {
					boolean valideNP = true;
					boolean valideIE = true;
					try {
						int noPatientInt = Integer.parseInt(noPatient);
						valideNP = noPatientInt >= 0 && noPatientInt <= 2147483647;
					} catch (NumberFormatException e1) {
						valideNP = false;
					}
					try {
						double indiceEffDouble = Double.parseDouble(indiceEff);
						valideIE = indiceEffDouble >= 0 && indiceEffDouble <= 2;
					} catch (NumberFormatException e1) {
						valideIE = false;
					}
					boolean valideP = false;
					for (String s : provincePossible) {
						if (s.equals(province)) {
							valideP = true;
						}
					}
					try {
						ResultSet rsNoPatient = stmt.executeQuery("select NO_PATIENT from TP_2_PATIENT");
						if (rsNoPatient.next()) {
							ArrayList<String> noPatientString = new ArrayList<String>();
							do {
								noPatientString.add(rsNoPatient.getString(1));
							} while (rsNoPatient.next());
							for (String s : noPatientString) {
								if (s.equals(noPatient)) {
									valideNP = false; // permet de vérifier
														// qu'il
														// n'y a pas deux
														// No_patient
														// pareil
								}
							}

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (valideNP == false || valideIE == false || valideP == false || noPatient.isEmpty()
							|| province.isEmpty() || indiceEff.isEmpty() || noPatient == null || province == null
							|| indiceEff == null) {
						JOptionPane.showMessageDialog(null, "Les param\u00E8tre de la fonciton ne sont pas valide!");
					} else {
						try {
							stmt.executeUpdate(
									"insert into TP_2_PATIENT(NO_PATIENT, PROVINCE_PAT, INDICE_EFFICACITE_METABO_PAT) values (\'"
											+ noPatient + "\',\'" + province + "\',\'" + indiceEff + "\')");
							stmt.executeUpdate(
									"insert into TP_2_ETUDE_PATIENT(NO_PATIENT, NUM_PATIENT_ETUDE, NO_ETUDE) values (\'"
											+ noPatient + "\',\'1111\',\'" + textEtude.getText() + "\')");
							// On ajoute 1111 au num patient etude pour testé,
							// car
							// les num doivent etre not null
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Patient ajouté dans: \'" + textEtude.getText() + "\'");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Les param\u00E8tre de la fonciton ne sont pas valide!");
				}
			}
		});

		btnSupprimerPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rsNoPatient = stmt.executeQuery("select NO_PATIENT from TP_2_PATIENT");
					if (rsNoPatient.next()) {
						String noPatient = "";
						noPatient = JOptionPane
								.showInputDialog("Quel est le num\u00E9ro du patient que vous voulez supprim\u00E9?");
						ArrayList<String> noPatientString = new ArrayList<String>();
						do {
							noPatientString.add(rsNoPatient.getString(1));
						} while (rsNoPatient.next());
						boolean patientExist = false;
						for (String s : noPatientString) {
							if (s.equals(noPatient)) {
								patientExist = true;
							}
						}
						if (patientExist) {
							try {
								stmt.executeUpdate(
										"delete from TP_2_ETUDE_PATIENT where NO_PATIENT = \'" + noPatient + "\'");
								stmt.executeUpdate("delete from TP_2_PATIENT where NO_PATIENT = \'" + noPatient + "\'");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Le patient \'" + noPatient + "\' est supprim\u00E9!");
						} else {
							JOptionPane.showMessageDialog(null, "Le patient \'" + noPatient + "\' n\'existe pas!");
						}

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		//
	}
}
