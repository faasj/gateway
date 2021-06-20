insert into functions
values (
    'f28f60d9-60f7-4e13-9602-1a3fc4298d0c',
    'testFunction',
    'public class Main { public static void main(String[] args) {} }',
    'test function',
    'http://google.com/',
    '2021-06-15 18:00:00',
    '2021-06-15 18:00:00',
    'f28f60d9-60f7-4e13-9602-1a3fc4298d01',
    '{"tag": "test", "tag1": "test1"}',
    '{"environmentVariables": "var", "environmentVariables1": "var1"}',
    '{"limits": "val", "limits1": "val1"}',
    '{"requests": "request", "requests1": "request1"}'
);
insert into projects
values (
  '3fa85f64-5717-4562-b3fc-2c963f66afa6',
  'calc',
  '2021-06-20 18:00:00',
  '2021-06-20 18:00:00',
  '3fa85f64-5717-4562-b3fc-2c963f66afa6',
  '{"additionalProp1": "1string", "additionalProp2": "2string", "additionalProp3": "3string"}'
    );

--        private UUID projectId;
--        private String projectName;
--        private LocalDateTime createDate;
--        private LocalDateTime updateDate;
--        private UUID ownerId;
--        private Map<String, String> tags;
