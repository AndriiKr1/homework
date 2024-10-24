Предположим, ваша программа предоставляет пользователю возможность отослать письмо одним из 3 возможных способов:
        DHL, E-Mail, Owl. 
Вам необходимо реализовать один общий метод отправки почты, который в качестве параметра получает способ отправки почты.
Реализация каждого из способов, должна быть выполнена отдельным методом 
    (каждый метод может просто выводить на экран соответствующее сообщения,
    например, в случае DHL, что то типа: «кладу письмо в конверт, клею марку, иду на  почту»). 
Выбор способа отправки определяется пользователем, например через Scanner

• Создать интерфейс MailDeliveryService с одним методом void sendMail().
• Создайте класс DHL, который должен реализовать интерфейс MailDeliveryService. 
    Способ отправки почты — напечатать что-то вроде: «Положи письмо в конверт, поставь марку, отправь».
• Создайте класс Email, который должен реализовать интерфейс MailDeliveryService. 
    Его способ отправки почты - напечатать что-то вроде: «Отправить по Интернету».
• Создайте класс Owl, который должен реализовать интерфейс MailDeliveryService. 
    Его способ отправки почты — напечатать что-то вроде: «Привет Гарри Поттер!»
• Создайте класс Sender с методом send в нем. 
    В качестве аргумента этот метод принимает MailDeliveryService и отправляет почту ( вызывает метод sendMail() )  с помощью данной службы.
• В соответствие с выбором пользователя, создайте нужный объект  MailDeliveryService и с помощью  Sender  отправьте почту.