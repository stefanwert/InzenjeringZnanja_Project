package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Attack implements CaseComponent {

    private String name;
    private String parentOf;
    private String canFallow;
    private String domainsOfAttack;
    private String mitigations;
    private String weakness;

    public  Attack(){}

    @Override
    public String toString() {
        return "Attack{" +
                "name='" + name + '\'' +
                ", parentOf='" + parentOf + '\'' +
                ", canFallow='" + canFallow + '\'' +
                ", domainsOfAttack='" + domainsOfAttack + '\'' +
                ", mitigations='" + mitigations + '\'' +
                ", weakness='" + weakness + '\'' +
                '}';
    }

    public String getParentOf() {
        return parentOf;
    }

    public void setParentOf(String parentOf) {
        this.parentOf = parentOf;
    }

    @Override
    public Attribute getIdAttribute() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCanFallow() {
        return canFallow;
    }

    public void setCanFallow(String canFallow) {
        this.canFallow = canFallow;
    }

    public String getDomainsOfAttack() {
        return domainsOfAttack;
    }

    public void setDomainsOfAttack(String domainsOfAttack) {
        this.domainsOfAttack = domainsOfAttack;
    }

    public String getMitigations() {
        return mitigations;
    }

    public void setMitigations(String mitigations) {
        this.mitigations = mitigations;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
}
