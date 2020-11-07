### Реализовать мини фреймворк - DIContainer:
1. Наличие аннотации ConfigClass предполагает создание экземпляра данного класса, 
значения свойств созданного объекта получить из config файла
2. Наличие аннотации RequiredClass предполагает создание экземпляра данного класса
3. Наличие аннотации RequiredField предполагает необходимость инициализировать значение данного свойства
4. Дополнительно можно добавить аннотации (Max, Min, NotNull и тд) которые можно использовать для аргументов методов (полей классов)

Использование:
    
    Set<Class> classes = new HashSet<>();
    classes.add(Cat.class);
    classes.add(Mouse.class);
    classes.add(Owner.class);
    classes.add(AnimalsConfig.class);
    
    DIContainer container = инициализация DIContainer с передачей коллекции
    
    в итоге должна быть возможноть получить объект из контейнера по имени класса ("Cat") или по ссылке на класс (Cat.class),
    вызвать доступные методы полученного объекта:
    
    container.getObj("Cat").catchMouse(container.getObj("Mouse"));
    container.getObj(Cat.class).catchMouse(container.getObj(Mouse.class));

Создаваемые экземпляры необходимо хранить в мапе, чтобы иметь возможность обратиться к ним в дальнейшем 



