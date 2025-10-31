package dev.datlag.kommons


data object Nicaragua : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NIC")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(558)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(505)
    override val continent: Continent = Continent.NorthAmerica
}