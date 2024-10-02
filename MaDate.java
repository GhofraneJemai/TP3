import java.util.Calendar;
public class MaDate {
    private int jour;
    private int mois;
    private int annee;
	
    public int getJour() {
        return jour;
    }
    public int getMois() {
        return mois;
    }
    public int getAnnee() {
        return annee;
    }
    public void setJour(int jour) {
        this.jour = jour;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
	
	public MaDate(int jour, int mois, int annee) {
	this(annee);
    this.jour = jour;
    this.mois = mois;
	}
	public MaDate(int annee) {
    Calendar now = Calendar.getInstance(); 
    this.jour = now.get(Calendar.DAY_OF_MONTH); 
    this.mois = now.get(Calendar.MONTH) + 1;    
    this.annee = annee;   
	}
    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }
    public void ajouterUnJour() {
		jour++;
		//30j
        if ((mois == 4 || mois == 6 || mois == 9 || mois == 11) && jour > 30) {
            jour = 1;
            mois++;
        }
		//31j
        else if ((mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) && jour > 31) {
            jour = 1;
            mois++;
        }
        else if (mois == 2) {
            if (estBissextile() && jour > 29) {
                jour = 1;
                mois++;
            } else if (!estBissextile() && jour > 28) {
                jour = 1;
                mois++;
            }
        }
        if (mois > 12) {
            mois = 1;
            annee++;
		}
	}
    private boolean estBissextile() {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }
    public void ajouterPlusieursJours(int n) {
        for (int i = 0; i < n; i++) {
            ajouterUnJour();
        }
    }	

    public void ajouterUnMois() {
        mois++;
        if (mois > 12) {
            mois = 1;
            annee++;
        }
    }
    public void ajouterUnAn() {
        annee++;
    }
}