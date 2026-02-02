CREATE TABLE prices (
                        brand_id       INT NOT NULL,
                        start_date     TIMESTAMP WITH TIME ZONE NOT NULL,
                        end_date       TIMESTAMP WITH TIME ZONE NOT NULL,
                        price_list     INT NOT NULL,
                        product_id     INT NOT NULL,
                        priority       INT NOT NULL,
                        price          DECIMAL(10,2) NOT NULL,
                        currency       VARCHAR(3) NOT NULL,
                        last_update    TIMESTAMP WITH TIME ZONE NOT NULL,
                        last_update_by VARCHAR(50) NOT NULL,

                        CONSTRAINT pk_prices PRIMARY KEY (price_list)
);
