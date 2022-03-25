package ru.evgrafova;

    //1.Класс отдается для загрузки в систему загрузчиков класса ClassLoaders. Класс загружается в Metaspace.
    public class JvmComprehension {

        //2.В момент вызова метода main создается фрейм(кадр) в стеке.
        public static void main(String[] args) {
            // 3.int это примитив, его значение сохраняется в стеке (фрейм main)
            int i = 1;

            //4.Обьект o сохраняется в куче, ссылка на этот объект сохраняется в стеке (фрейм main)
            Object o = new Object();

            //5.Объект ii сохранятется в куче, ссылка на этот объект сохраняется в стеке (фрейм main)
            Integer ii = 2;

            //6. в момент вызова printAll  в стеке создается новый фрейм для этого метода.
            // В нем сохраняются все переданные в него параметры
            // (ссылки на Object o и Integer ii (которые лежат в куче) и значение int i)
            printAll(o, i, ii);
            //13. уничтожается фрейм printAll
            //14.В стеке создается новый фрейм для метода println,
            // в параметры которого сохраняется ссылка на String (который сохраняется в куче).
            System.out.println("finished");
            //15. После завершения методов println и main их фреймы уничтожаются


            //С объектами в куче при уничтожении фреймов ничего не происходит,
            // их уничтожает при обходе сборщик мусора, если они становятся недостижимы.
            //Либо они уничтожаются при завершении программы.
        }

        private static void printAll(Object o, int i, Integer ii) {
            //7. В куче сохраняется объект uselessVar, в стеке (фрейм printAll) сохраняется ссылка на него
            Integer uselessVar = 700;
            //8. В стеке создается новый фрейм для метода println
            //9. во фрейме println сохраняется ссылка на объект StringBuilber(который скрывается за конкатенацией).
            // Сами объекты сохранаются в куче.
            //10. В стеке cоздается новый фрейм для метода toString, в котором будет сохранена ссылка на Object o.
            // После завершения метода фрейм уничтожается.
            //11.В стеке создается создается новый фрейм для метода append обьекта StringBuilder,
            // в параметры которого передадутся ссылки на объект полученный от метода toString,
            // ссылка на объект ii и значение i.После завершения метода фрейм уничтожается.
            //12. на экран выводятся данные, метод println завершается, его фрейм уничтожается.
            System.out.println(o.toString() + i + ii);  // 6
        }
    }
