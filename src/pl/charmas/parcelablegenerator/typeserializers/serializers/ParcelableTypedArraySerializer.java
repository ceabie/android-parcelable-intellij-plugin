package pl.charmas.parcelablegenerator.typeserializers.serializers;

import com.intellij.psi.PsiField;
import pl.charmas.parcelablegenerator.typeserializers.TypeSerializer;
import pl.charmas.parcelablegenerator.util.PsiUtils;

public class ParcelableTypedArraySerializer implements TypeSerializer {
    private String mCreatorName;


    @Override
    public String writeValue(PsiField field, String parcel, String flags) {
        return parcel + ".writeTypedArray(this." + field.getName() + ", 0);";
    }

    @Override
    public String readValue(PsiField field, String parcel) {
        return "this." + field.getName() + " = " + parcel + ".createTypedArray("
                + field.getType().getDeepComponentType().getCanonicalText() + "."
                + mCreatorName + ");";
    }

    public ParcelableTypedArraySerializer(String creatorName) {
        mCreatorName = creatorName;
    }
}
