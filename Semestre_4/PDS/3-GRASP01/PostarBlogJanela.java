import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PostarBlogJanela extends JFrame implements ActionListener {

	JButton publicar;
	JTextField titulo;
	JTextArea corpo;
	ControladorPost controladorPost;
	//RepositorioPosts repositorioPosts;
	
	public PostarBlogJanela() {
        //this.controladorPost = controladorPost;
		titulo = new JTextField("Digite o título...");
		this.add(titulo,BorderLayout.NORTH);
		
		corpo = new JTextArea("Corpo de texto do post...");
		this.add(corpo,BorderLayout.CENTER);
		
		publicar = new JButton("Publicar Post");
		publicar.addActionListener(this);
		this.add(publicar,BorderLayout.SOUTH);
		
		//repositorioPosts = new RepositorioPosts();
        controladorPost = new ControladorPost();        
	}

	public static void main(String[] args){
        PostarBlogJanela postarBlogJanela =  new PostarBlogJanela();
        postarBlogJanela.mostrar();
	}

	private void mostrar() {
		this.setSize(400,400);
		this.setLocation(100, 100);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent publicarPost) {
		//Post post = new Post();
		//post.setTitulo(this.titulo.getText());
		//post.setCorpoTexto(this.corpo.getText());
		//repositorioPosts.adicionar(post);
        controladorPost.adicionaPost(this.titulo.getText(), this.corpo.getText());
	}
}