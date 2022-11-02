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

        Annotation a = null;

        for (Annotation obj : annotations) {
            if (obj.checkPoint(x, y)) {
                a = obj;
                break;
            }
        }

        return a;
    }

    public Annotation findByLabel(String label) {

        Annotation a = null;

        for (Annotation obj : annotations) {
            if (obj.getLabel().contains(label)) {
                a = obj;
                break;
            }
        }

        return a;
    }
}
