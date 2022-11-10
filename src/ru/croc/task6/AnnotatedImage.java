package ru.croc.task6;

class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {

        for (Annotation obj : annotations)
            if (obj.getFigure().checkPointInArea(x, y))
                return obj;

        return null;
    }

    public Annotation findByLabel(String label) {

        for (Annotation obj : annotations)
            if (obj.getLabel().contains(label))
                return obj;

        return null;
    }
}
