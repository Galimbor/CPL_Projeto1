package Symbols;

import java.util.HashMap;

public class ScopeOLD {

    private final HashMap<String, SymbolOLD> symbols;
    private final ScopeOLD parentScopeOLD;

    public ScopeOLD(ScopeOLD parentScopeOLD) {
        this.symbols = new HashMap<>();
        this.parentScopeOLD = parentScopeOLD;
    }

    public ScopeOLD getParentScope() {
        return this.parentScopeOLD;
    }

    public boolean isGlobalScope() {
        return this.parentScopeOLD == null;
    }

    public boolean define(SymbolOLD symbolOLD) {
        if (this.symbols.containsKey(symbolOLD.name)) return false;
        symbolOLD.scopeOLD = this;
        this.symbols.put(symbolOLD.name, symbolOLD);
        return true;
    }

    public SymbolOLD resolve(String name) {
        SymbolOLD s = this.symbols.get(name);
        if (s != null) return s;

        if (this.parentScopeOLD != null) return this.parentScopeOLD.resolve(name);
        return null;
    }

    public String toString() {
        return this.symbols.values().toString();
    }
}
