package interfaces;

import java.util.*;

public interface INodo {
public String getRaiz();
public List<INodo> getDescendientes();
public int getnumDescendientes();
public void incluirDescendiente(INodo nodo);
public double calcular();
public INodo copy();
} 
