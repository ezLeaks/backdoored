package org.spongepowered.tools.obfuscation.mapping;

import org.spongepowered.tools.obfuscation.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import java.util.*;
import com.google.common.base.*;
import org.spongepowered.asm.obfuscation.mapping.*;

public interface IMappingConsumer
{
    void clear();
    
    void addFieldMapping(final ObfuscationType p0, final MappingField p1, final MappingField p2);
    
    void addMethodMapping(final ObfuscationType p0, final MappingMethod p1, final MappingMethod p2);
    
    MappingSet<MappingField> getFieldMappings(final ObfuscationType p0);
    
    MappingSet<MappingMethod> getMethodMappings(final ObfuscationType p0);
    
    public static class MappingSet<TMapping extends java.lang.Object> extends LinkedHashSet<Pair<TMapping>>
    {
        private static final long serialVersionUID = 1L;
        
        public MappingSet() {
            super();
        }
        
        public static class Pair<TMapping extends java.lang.Object>
        {
            public final TMapping from;
            public final TMapping to;
            
            public Pair(final TMapping a1, final TMapping a2) {
                super();
                this.from = (IMapping)a1;
                this.to = (IMapping)a2;
            }
            
            @Override
            public boolean equals(final Object a1) {
                if (!(a1 instanceof Pair)) {
                    return false;
                }
                final Pair<TMapping> v1 = (Pair<TMapping>)a1;
                return Objects.equal(this.from, v1.from) && Objects.equal(this.to, v1.to);
            }
            
            @Override
            public int hashCode() {
                return Objects.hashCode(this.from, this.to);
            }
            
            @Override
            public String toString() {
                return String.format("%s -> %s", this.from, this.to);
            }
        }
    }
}
