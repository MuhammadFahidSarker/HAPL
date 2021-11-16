package com.fsapps.HTPL.pro_visit;


import java.util.HashMap;
import java.util.Map;

public class Scope {

    private Scope parent;
    private Map<String, HTPL> variables;
    private boolean isFunction;

    public Scope() {
        // only for the global scope, the parent is null
        this(null, false);
    }

    Scope(Scope p, boolean function) {
        parent = p;
        variables = new HashMap<>();
        isFunction = function;
    }

    public void assignParam(String var, HTPL value) {
        variables.put(var, value);
    }

    public void assign(String var, HTPL value) {
        if(resolve(var, !isFunction) != null) {
            // There is already such a variable, re-assign it
            this.reAssign(var, value);
        }
        else {
            // A newly declared variable
            variables.put(var, value);
        }
    }

    private boolean isGlobalScope() {
        return parent == null;
    }

    public Scope parent() {
        return parent;
    }

    private void reAssign(String identifier, HTPL value) {
        if(variables.containsKey(identifier)) {
            // The variable is declared in this scope
            variables.put(identifier, value);
        }
        else if(parent != null) {
            // The variable was not declared in this scope, so let
            // the parent scope re-assign it
            parent.reAssign(identifier, value);
        }
    }

    public HTPL resolve(String var) {
        return resolve(var, true);
    }

    private HTPL resolve(String var, boolean checkParent) {
        HTPL value = variables.get(var);
        if(value != null) {
            // The variable resides in this scope
            return value;
        }
        else if(checkParent && !isGlobalScope()) {
            // Let the parent scope look for the variable
            return parent.resolve(var, !parent.isFunction);
        }
        else {
            // Unknown variable
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, HTPL> var: variables.entrySet()) {
            sb.append(var.getKey()).append("->").append(var.getValue()).append(",");
        }
        return sb.toString();
    }
}